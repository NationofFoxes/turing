package turing;

public class Tape {

    Tape() {
        Cell runner = new Cell();
        runner.content = ' ';
        runner.next = null;
    }

    public Cell runner = new Cell();


    public Cell getCurrentCell() {      //returns the pointer that points to the current cell.
        return runner;
    }

    public char getContent() {      //returns the char from the current cell.
        //runner = runner.next;
        return runner.content;
    }


    public void setContent(char ch) {//changes the char in the current cell to the specified value.
        runner.content = ch;
    }

    public void moveLeft() {            //moves the runner cell one position to the left along the tape.
        if (runner.prev == null) {
            Cell before = new Cell();
            before.content = ' ';
            runner.prev = before;
            before.next = runner;
            runner = before;
        }
        else{
            runner = runner.prev;
        }
    }

    public void moveRight() {           //moves the runner cell one position to the left along the tape.
        if (runner.next == null){
            Cell after = new Cell();
            after.content = ' ';
            after.prev = runner;
            runner.next = after;
            runner = after;
        }
        else{
            runner = runner.next;
        }
    }

    public String getTapeContents() {

        String elements = "";       // An array to hold the list elements.
        Cell read;
        read = runner;
        while (read.prev != null){
            read = read.prev;
        }
        while (read.next != null){
            elements += read.content;
            read = read.next;
        }

        return elements;

    }

}
