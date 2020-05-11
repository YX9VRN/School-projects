class palya:
    #class a külömböző elemekre
    jatekos = '@'
    doboz = '$'
    padlo = ' '
    fal = '#'
    cel = '.'
    doboz_helyen = '*'
    jatekos_celon = '+'
 
       
def txt_be():
    '''Ez a fuggveny beolvas egy txt fajlt amibol eloallit egy ketdimenzios tombot ami alapjan majd
    kirajlzoljuk a terkepet'''
   
    poz_matrix = []
    item = ('')
    
    
    with open ('test.txt','r') as f:
        
        for line in f:
            line = line.rstrip('\n')
            sorok = []
            for i in line:
                if i == palya.jatekos:
                    item = palya.jatekos
                    sorok.append(item)
                    
                elif i == palya.doboz:
                    item = palya.doboz
                    sorok.append(item)
                    
                elif i == palya.padlo:
                    item = palya.padlo
                    sorok.append(item)
                    
                elif i == palya.fal:
                    item = palya.fal
                    sorok.append(item)
                elif i == palya.cel:
                    item = palya.cel
                    sorok.append(item)
                    
                elif i == palya.doboz_helyen:
                    item = palya.doboz_helyen
                    sorok.append(item)
                    
                elif i == palya.jatekos_celon:
                    item = palya.jatekos_celon
                    sorok.append(item)   
            poz_matrix.append(sorok)       
    return poz_matrix