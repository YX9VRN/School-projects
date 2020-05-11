import pygame, random, time, pygame, mozg

def button(msg, w, h, x, y, inact_color, active_color, surface):
        '''Ez egy fuggveny amivel gombokat lehet megadni
        át lehet adni a függvenynek a gomb paramétereit
        '''
        zold = (34, 242, 7)
        pygame.init()
        mouse = pygame.mouse.get_pos()
        
        click = pygame.mouse.get_pressed()
        font = pygame.font.Font('betu.ttf',40) 
        
         
        event = pygame.event.wait()
        if x < mouse[0] < x+w and y < mouse[1] < y+h:
            pygame.draw.rect(surface,active_color,(x,y,w,h))   
            pygame.draw.rect(surface,active_color,(x+4,y+4,w-8,h-8))
            if click[0] == 1:
                    return True
                    
            
        else:
            pygame.draw.rect(surface,active_color,(x,y,w,h))  
            pygame.draw.rect(surface,inact_color,(x+4,y+4,w-8,h-8))
            
        text = font.render(msg,False,zold)
        surface.blit(text,(x+(w-text.get_width())/2,y))
        
        return False
class player:
        def __init__(self):
                self.name = none
                self.level = none
                self.point = none

def intro():
        
    pygame.init()
    
    dp_w = 1000
    dp_h = 700
    window = pygame.display.set_mode((dp_w,dp_h)) #ablak merete
    pygame.display.set_caption('Sokoban')
    
    pygame.time.set_timer(pygame.USEREVENT, 20)
     
    zold = (34, 242, 7)
    fekete = (0,0,0)
    feher = (255,255,255)
    window.fill(fekete)
    for i in range(1000):
            pygame.draw.rect(window,feher,(random.randint(0,dp_w),random.randint(0,dp_h),2,2))
            
    quit = False
    start = False
    clear = False
    while not quit and start == False:
        pygame.init()
        event = pygame.event.wait()
        if event.type == pygame.QUIT:
                    quit = True
        if event.type == pygame.USEREVENT:
                
                pygame.init()
                font = pygame.font.Font('betu.ttf',102)
                text = font.render('sokoban',False,zold)
                window.blit(text,((dp_w-text.get_width())/2,dp_h/8))

          
                
                start = button('START',300,40,dp_w/2-150,dp_h/3,fekete,feher,window)
                quit_b = button('QUIT',300,40,dp_w/2-150,(dp_h/3)+60,fekete,feher,window)
                leaderboard = button('LEADERBOARD',300,40,dp_w/2-150,(dp_h/2)+20,fekete,feher,window)


                font = pygame.font.Font('betu.ttf',20)
                text = font.render('Cserhati Szilveszter 2018', False, feher )
                window.blit(text,((dp_w-text.get_width())/2, dp_h-20))
               
                if quit_b == True:
                        quit = True
                if start == True:
                        window.fill(fekete)
                        mozg.mozgatas()
                     
                        
                pygame.display.update()       
    pygame.time.set_timer(pygame.USEREVENT, 0)
   
def main():  
    intro() 
main()
