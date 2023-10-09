package Invokers;

import Interfaces.Command;

public class SortAndSearchInvoker {
    Command sortMenu;
    Command searchMenu;

    public SortAndSearchInvoker(Command sortMenu, Command searchMenu) {
        this.sortMenu = sortMenu;
        this.searchMenu = searchMenu;
    }

    public void callSortMenu(){
        sortMenu.execute();
    }

    public void callSearchMenu(){
        searchMenu.execute();
    }
}
