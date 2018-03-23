import cv2
import numpy as np

faceDetect=cv2.CascadeClassifier('haarcascade_frontalface_default.xml');
cam=cv2.VideoCapture(1);
rec=cv2.face.LBPHFaceRecognizer_create();
rec.read("recognizer\\traningData.yml")


font = cv2.FONT_HERSHEY_COMPLEX_SMALL
while(True):
    ret,img=cam.read();
    gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY);
    faces=faceDetect.detectMultiScale(gray,1.3,5);
    for(x,y,w,h) in faces:
        cv2.rectangle(img,(x,y),(x+w,y+h),(0,255,0),2)
        Id,conf=rec.predict(gray[y:y+h,x:x+w])
        if(conf<57):
            if(Id==1):
                Id="Lindan"
#            elif(Id==2):
###                Id="Sam"
        else:
            Id="Unknown"
        cv2.putText(img,str(Id),(x,y+h),font,3.0,(0,255,0));
        print(conf);
    cv2.imshow("face",img);
    if(cv2.waitKey(1)==ord('q')):
        break;
cam.release()
cv2.destroyAllWindows()
