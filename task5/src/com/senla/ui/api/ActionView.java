package com.senla.ui.api;

public abstract class ActionView extends AbstractView {

    public ActionView(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu);
    }

    public ActionView(String runningTitle, String nameInParentMenu, ViewConfig viewConfig) {
        super(runningTitle, nameInParentMenu, viewConfig);
    }

    public abstract void executeCustomAction();

    @Override
    public void display() {
        this.println();
        this.println(this.runningTitle);
        this.executeCustomAction();
        this.pause();
        this.goBack();
    }
}
