import datasetCreator as d
import trainer as t
import time
from threading import Thread

def creatorAndTrainer():
    successData=d.creationMechanism();

    if successData==True:
        t.trainingMechanism()
    else:
        print("Something went wrong, try again")
