from Tkinter import *
import cv2
import time
import numpy as np


root = Tk()

def destroyAll():
    root.destroy()
    
faceDetect=cv2.CascadeClassifier('haarcascade_frontalface_default.xml');

def creationMechanism():
        #GUI
        root.title("Information required")
        root.geometry("450x150+500+400") #Works for the Surface Screen

        infoPrompt=Label(root,text="Please enter your name:",
                         font=("arial",12,"bold")).place(x=10,y=30)

        name=StringVar() #user name stored here
        entry_box = Entry(root, textvariable=name, width=35).place(x=220,y=33)



        okButton= Button(root, text="Ok", width=25, height=2,
                         command=destroyAll).place(x=140,y=100)

        root.mainloop();

        sampleNum=0;
        #id=raw_input('Please enter your name: ')

        #Frontal face capture
        
        if len(name.get()) == 0:
            print("Cant leave name field empty")
            return False
        else:
            cam=cv2.VideoCapture(1);
            while(True):
                ret,img=cam.read();
                gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY);
                faces=faceDetect.detectMultiScale(gray,1.3,5);
                for(x,y,w,h) in faces:
                    sampleNum=sampleNum+1;
                    cv2.imwrite("facesDataTest/"+str(name.get())+ "." +str(sampleNum)+ ".jpg", gray[y:y+h, x:x+w])
                    cv2.rectangle(img,(x,y),(x+w,y+h),(0,255,0),2)
                    cv2.waitKey(100);
                cv2.imshow("face",img);
                cv2.waitKey(1)
                if(sampleNum>20):
                    break
                
            cam.release()
            cv2.destroyAllWindows()
            return True
