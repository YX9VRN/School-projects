
import pygame
import random
import be
pygame.init()
k_sz = 800
k_m = 600
window = pygame.display.set_mode((k_sz,k_m))
pygame.display.set_caption('Sokoban')
feher = (255,255,255)
fekete = (0,0,0)
#poz_matrix = be.txt_be()

class palya:
    #class a külömböző elemekre
    jatekos = '@'
    doboz = '$'
    padlo = ' '
    fal = '#'
    cel = '.'
    doboz_helyen = '*'
    jatekos_celon = '+'
 

        
def kirajzol(poz_matrix):
    '''a beolvas fuggveny alapjan kirajzolja a jatekteret a kepek merete dinamikusan allithato, barmilyen
    kepet rakunk be a mappaba az a valos mereteben fog megjelenni '''
    
    
    '''A jelenlegi skin a http://www.joriswit.nl/sokoban/en/skins.htm oldalról van a végleges programhoz egyedi skint készítek,
    ami illik a menü témájához'''
    #itt töltöm be a képeket
    doboz = pygame.image.load('images/plumbus.png')
    fal = pygame.image.load('images/fal_v.png')
    cel = pygame.image.load('images/cel.png')
    jatekos = pygame.image.load('images/rick.png')
    padlo = pygame.image.load('images/padlo_v.png')
    doboz_celon = pygame.image.load('images/plumbus_celon.png')
    jatekos_celon = pygame.image.load('images/rick_celon.png')
    elem_m = doboz.get_width()
    # be raktam a képeket egy 'szótárba', hogy könnyeb legyen vele a munka
    kepek = {'#': fal, ' ': padlo, '$': doboz, '.': cel, '@': jatekos, '*': doboz_celon, '+' : jatekos_celon}
    for i in range(0,len(poz_matrix)):
        #sorok vizsgalata
        for j in range(0,len(poz_matrix[i])):
            #sor elemek vizsgalata
            window.blit(kepek[poz_matrix[i][j]],(j*elem_m,i*elem_m))#kirajzolja a jatekteret
        pygame.display.update()

def jatekos_poz(poz_matrix):
    '''Ez a függveény adja meg a játékos pozicióját'''
    poz = [0,0]
    for i in range(0,len(poz_matrix)):
        for j in range(0,len(poz_matrix[i])):
            if poz_matrix[i][j] == '@' or poz_matrix[i][j] =='+':
                poz = [i,j]
    # kételemű tömbbel tér vissza
    return(poz)
            
def jatek(irany, poz_matrix, j_poz):
    
    '''Ez a függvény szolgáltatja a játémechanikáját játékos mozgatás láda mozgatás stb...'''
    pygame.init()
    #elmentem egy változóba a beolvasott, mátrixot
    matrix = be.txt_be()
    #kimentem a játékos x és y pozicióját
    
    x = j_poz[1]
    y = j_poz[0]


    if irany == 'Jobbra':
         
         if poz_matrix[y][x+1] == ' ':
             #padlo lesz ha az inpit jobbra nyíl
             poz_matrix[y][x+1] = '@'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] ='.'
             else :
                 poz_matrix[y][x] = ' '
             
             x += 1
         elif poz_matrix[y][x+1] =='$' and poz_matrix[y][x+2] != '#' and poz_matrix[y][x+2] !='$' and poz_matrix[y][x+2] !='*':
             #doboz lesz ha az input jobbra nyíl
             if poz_matrix[y][x+2] == '.':
                 poz_matrix[y][x+2] = '*'
             else:
                 poz_matrix[y][x+2] = '$'
             
             poz_matrix[y][x+1] = '@'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] ='.'
             else:
                 poz_matrix[y][x] = ' '
             x += 1
        
         elif poz_matrix[y][x+1] == '*' and  poz_matrix[y][x+2] != '#' and poz_matrix[y][x+2] !='$' and poz_matrix[y][x+2] !='*':
             #doboz_celon lesz, ha az input jobbra nyíl 
             if poz_matrix[y][x+2] == '.':
                 poz_matrix[y][x+2] = '*'
             else:
                 poz_matrix[y][x+2] = '$'
             poz_matrix[y][x+1] ='+'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] = '.'
             elif poz_matrix[y][x] =='@':
                 poz_matrix[y][x] = ' '
             
             x += 1
         elif poz_matrix[y][x+1] == '.':
              poz_matrix[y][x+1] = '+'
              if poz_matrix[y][x] =='+':
                  poz_matrix[y][x] = '.'
              elif poz_matrix[y][x] =='@':
                  poz_matrix[y][x] = ' '
              x+=1
             
         
    if irany == 'Balra':
       
        if poz_matrix[y][x-1] == ' ':
             poz_matrix[y][x-1] = '@'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] ='.'
             else :
                 poz_matrix[y][x] = ' '
             
             x -= 1
            
        elif poz_matrix[y][x-1] =='$' and poz_matrix[y][x-2] != '#' and poz_matrix[y][x-2] !='$' and poz_matrix[y][x-2] !='*':
             if poz_matrix[y][x-2] == '.':
                 poz_matrix[y][x-2] = '*'
             else:
                 poz_matrix[y][x-2] = '$'
             poz_matrix[y][x-1] = '@'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] ='.'
             else:
                 poz_matrix[y][x] = ' '
             x -=1
        elif poz_matrix[y][x-1] == '*' and  poz_matrix[y][x-2] != '#' and poz_matrix[y][x-2] !='$' and poz_matrix[y][x-2] !='*':
             
             if poz_matrix[y][x-2] == '.':
                 poz_matrix[y][x-2] = '*'
             else:
                 poz_matrix[y][x-2] = '$'
             poz_matrix[y][x-1] ='+'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] = '.'
             elif poz_matrix[y][x] =='@':
                 poz_matrix[y][x] = ' '
             
             x -= 1
        elif poz_matrix[y][x-1] == '.':
              poz_matrix[y][x-1] = '+'
              if poz_matrix[y][x] =='+':
                  poz_matrix[y][x] = '.'
              elif poz_matrix[y][x] =='@':
                  poz_matrix[y][x] = ' '
              x-=1
             
    if irany =='Le':
        
        if poz_matrix[y+1][x] == ' ':
             poz_matrix[y+1][x] = '@'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] ='.'
             else :
                 poz_matrix[y][x] = ' '
             
             y += 1
        elif poz_matrix[y+1][x] =='$' and poz_matrix[y+2][x] != '#' and poz_matrix[y+2][x] !='$'  and poz_matrix[y+2][x] !='*':
             if poz_matrix[y+2][x] == '.':
                 poz_matrix[y+2][x] = '*'
             else:
                 poz_matrix[y+2][x] = '$'
             poz_matrix[y+1][x] = '@'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] ='.'
             else:
                 poz_matrix[y][x] = ' '
             y +=1
        elif poz_matrix[y+1][x] == '*' and  poz_matrix[y+2][x] != '#' and poz_matrix[y+2][x] !='$' and poz_matrix[y+2][x] !='*':
             
             if poz_matrix[y+2][x] == '.':
                 poz_matrix[y+2][x] = '*'
             else:
                 poz_matrix[y+2][x] = '$'
             poz_matrix[y+1][x] ='+'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] = '.'
             elif poz_matrix[y][x] =='@':
                 poz_matrix[y][x] = ' '
             y += 1
        elif poz_matrix[y+1][x] == '.':
              poz_matrix[y+1][x] = '+'
              if poz_matrix[y][x] =='+':
                  poz_matrix[y][x] = '.'
              elif poz_matrix[y][x] =='@':
                  poz_matrix[y][x] = ' '
              y+=1
            
    if irany == 'Fel':
        
        if poz_matrix[y-1][x] == ' ':
             poz_matrix[y-1][x] = '@'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] ='.'
             else :
                 poz_matrix[y][x] = ' '
            
             y -= 1
        elif poz_matrix[y-1][x] =='$' and poz_matrix[y-2][x] != '#' and  poz_matrix[y-2][x] !='$' and poz_matrix[y-2][x] !='*':
             if poz_matrix[y-2][x] == '.':
                 poz_matrix[y-2][x] = '*'
             else:
                 poz_matrix[y-2][x] = '$'
             poz_matrix[y-1][x] = '@'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] ='.'
             else:
                 poz_matrix[y][x] = ' '
             y -=1
        elif poz_matrix[y-1][x] == '*' and  poz_matrix[y-2][x] != '#' and poz_matrix[y-2][x] !='$' and poz_matrix[y-2][x] !='*':
             
             if poz_matrix[y-2][x] == '.':
                 poz_matrix[y-2][x] = '*'
             else:
                 poz_matrix[y-2][x] = '$'
             poz_matrix[y-1][x] ='+'
             if poz_matrix[y][x] == '+':
                 poz_matrix[y][x] = '.'
             elif poz_matrix[y][x] =='@':
                 poz_matrix[y][x] = ' '
             y -= 1
        elif poz_matrix[y-1][x] == '.':
              poz_matrix[y-1][x] = '+'
              if poz_matrix[y][x] =='+':
                  poz_matrix[y][x] = '.'
              elif poz_matrix[y][x] =='@':
                  poz_matrix[y][x] = ' '
              y-=1
             
    kirajzol(poz_matrix)        
    return poz_matrix

def mozgatas():
    matrix = be.txt_be()
    kirajzol(matrix)
    j_poz = [0,0]
    j_poz = jatekos_poz(matrix)
    quit = False

    while not quit:
        for event in pygame.event.get():
            if event.type == pygame.KEYDOWN:
                
                if event.key == pygame.K_RIGHT:
                    matrix = jatek('Jobbra',matrix, j_poz)
                    j_poz = jatekos_poz(matrix)
   
                elif event.key == pygame.K_LEFT:
                    matrix = jatek('Balra',matrix, j_poz)
                    j_poz = jatekos_poz(matrix)
                    
                elif event.key == pygame.K_UP:
                    matrix = jatek('Fel',matrix, j_poz)
                    j_poz = jatekos_poz(matrix)
                    
                elif event.key == pygame.K_DOWN:
                    matrix = jatek('Le',matrix, j_poz)
                    j_poz = jatekos_poz(matrix)
            if event.type == pygame.QUIT:
                quit = True
    

                                           
                        
    
    

