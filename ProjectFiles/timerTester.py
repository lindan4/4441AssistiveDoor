# ten second countdown to New Year using Tkinter

from Tkinter import *
import time 

t_end=time.time()+10

def countDown(root):
    
   # lbl1.config(bg='yellow')
    lbl1.config(height=3, font=('times', 20, 'bold'))
    while t_end>=time.time():
        lbl1["text"] ="Done scanning in: "+ str(int(t_end - time.time()))
        root.update()
      #  time.sleep(1)
    root.destroy()
    
root = Tk()

lbl1 = Label()
lbl1.pack(fill=BOTH, expand=1)
root.geometry("250x100+800+100")
countDown(root)
root.mainloop()
