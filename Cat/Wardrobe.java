package Cat;

public class Wardrobe {
    String description; //описание шкафа
    private Item[] storage; //хранилище вещей
    private boolean isOpenDoors;//состояние двери


    public Wardrobe(String name, int storageMaxDimm) {

        this.storage = new Item[storageMaxDimm];
//        for (int i = 0; i < storageMaxDimm; i++) {
//            this.storage[i]=null;
//        }
        this.isOpenDoors = false;
        this.description = name;
        System.out.println("У нас новый \""+name+"\""+" на "+storageMaxDimm+" мест");
    }


    public boolean openDoor() {
        if (isOpenDoors) return false;
        isOpenDoors = true;
        return true;
    }


    public boolean closeDoor() {
        if (!isOpenDoors) return false;
        isOpenDoors = false;
        return true;
    }


    public Item getItem(int index) {
        index -= 1;
        if (!isOpenDoors) return null;
        if (index >= storage.length) return null;
        Item obj = storage[index];
        storage[index] = null;
        return obj;
    }


    public boolean setItem(Item obj, int index) {
        if (!isOpenDoors) return false;
        index -= 1;
        if (0 > index || this.storage.length <= index) return false;
        if (storage[index] != null) {
            System.out.println("полка занята");
            return false;
        } else {
            storage[index] = obj;
            return true;
        }
    }

    public void viewItems() {
        if (isOpenDoors) {
            System.out.println("в шкафу " + this.storage.length + " мест");
            StringBuilder forPrint = new StringBuilder();
            int count = 0;
            for (int i = 0; i < this.storage.length; i++) {
                if (this.storage[i] != null) {
                    count++;
                    forPrint.append (String.format("%5d  %s\n", i + 1,this.storage[i].getName()));
                }else {
                    forPrint.append(String.format("%5d  %s\n", i + 1," --- "));
                }
            }
            System.out.println("занято " + count + " мест(а|о)");
            System.out.println(forPrint);
        } else {
            System.out.println("шкаф закрыт");
        }
    }
}
