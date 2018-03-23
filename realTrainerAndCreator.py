import datasetCreator as d
import trainer as t
import time
from threading import Thread

if __name__ == "__main__":
    
    successData=d.creationMechanism();

    if successData==True:
        t.trainingMechanism()
    else:
        print("you fucked up")
