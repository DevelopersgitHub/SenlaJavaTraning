package com.senla.ui.api;

import java.util.ArrayList;
import java.util.List;

public class MenuView extends AbstractView {

    protected List<AbstractView> menuItems = new ArrayList<>();

    public MenuView(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu);
    }

    public MenuView(String runningTitle, String nameInParentMenu, ViewConfig viewConfig) {
        super(runningTitle, nameInParentMenu, viewConfig);
    }

    public void addMenuItem(AbstractView menuItem) {
        menuItem.parentView = this;
        this.menuItems.add(menuItem);
    }

    public void removeMenuItem(int index) {
        this.menuItems.remove(index);
    }

    public void removeMenuItem(AbstractView menuItem){
        this.menuItems.remove(menuItem);
    }

    public List<AbstractView> getMenuItems() {
        return new ArrayList<>(this.menuItems);
    }

    public void setMenuItems(List<AbstractView> menuItems) {
        this.menuItems = new ArrayList<>(menuItems);
    }

    private boolean isValidIndex(int index) {
        return index >= 1 && index <= this.menuItems.size() + 1;
    }

    @Override
    public void display() {

        this.println();

        this.println(this.runningTitle);

        for (int i = 0; i < this.menuItems.size(); ++i) {
            this.println(this.viewConfig.getIndexNumberFormatter().format(i) + this.menuItems.get(i).nameInParentMenu);
        }

        String backOrQuit = this.parentView == null ? this.viewConfig.getQuitMenuName() : this.viewConfig.getBackMenuName();

        this.println(this.viewConfig.getIndexNumberFormatter().format(this.menuItems.size()) + backOrQuit);

        Validator<Integer> indexNumberValidator = new Validator<Integer>() {
            @Override
            public boolean isValid(Integer index) {
                return isValidIndex(index);
            }
        };

        int selection = this.prompt(this.viewConfig.getMenuSelectionMessage(), Integer.class, indexNumberValidator);
        
        if (selection == this.menuItems.size() + 1) {
            this.goBack();
        } else {
            this.menuItems.get(selection - 1).display();
        }
    }

}
