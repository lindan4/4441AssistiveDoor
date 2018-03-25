import realTrainerAndCreator as r
import detector as d
import dataDeleteMechanism as ddm


if __name__ == "__main__":

    i=0

    while i !=-1:
        i=raw_input("\n\nPress 1 for new profile.\nPress 2 for recognition\nPress 3 for deletion\n"+
                    "Press -1 to quit\n>>> ")
        i=int(i)
       # print i
        if i==1:
            r.creatorAndTrainer()
        elif i==2:
            d.faceDetector()
        elif i==3:
            ddm.deleteTrace()
