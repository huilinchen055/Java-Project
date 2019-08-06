public class Room {
    //attributes
    int numberInRoom;
    private static int totalNumber=0;

    //constructor
    public Room (int numberInRoom){
        this.numberInRoom=numberInRoom;
        this.totalNumber+=numberInRoom;}

    public void addOneToRoom (){
        numberInRoom += 1;
        totalNumber +=1;
    }

    public void removeOneFromRoom (){
        if (numberInRoom >0)
        {numberInRoom -=1;
        totalNumber -=1;}
    }

    public int getNumber (){
        return numberInRoom;
    }

    public static int getTotal (){
        return totalNumber;
    }

}
