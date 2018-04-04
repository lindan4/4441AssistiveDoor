from Tkinter import *

def noButton():
        print "you chose no"
        root.destroy()

def yesButton():
        print "you chose yes"
        root.destroy()

root=Tk()
root.title("Are you sure?")
root.geometry("450x150+500+400")
unAuthorizedLabel= Label(root,text="This will destroy all your files and you won't be \nrecognized by the system. \nAre you sure?",
                        font=("arial",12,"bold")).place(x=25,y=25)

yesButton= Button(root, text="Yes", width=25, height=2,
                command=yesButton).place(x=2,y=100)
noButton= Button(root, text="No", width=25, height=2,
                command=noButton).place(x=263,y=100)
root.mainloop();
