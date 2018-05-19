package com.senla.ui.api;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;


public abstract class AbstractView {

  
    protected AbstractView parentView;
    
    protected String runningTitle;

    protected String nameInParentMenu;
    
    protected ViewConfig viewConfig;

    protected Scanner keyboard = new Scanner(System.in);

    public AbstractView(String runningTitle, String nameInParentMenu) {
        this.runningTitle = runningTitle;
        this.nameInParentMenu = nameInParentMenu;
        this.viewConfig = ViewConfig.DEFAULT;
    }

    public AbstractView(String runningTitle, String nameInParentMenu, ViewConfig viewConfig) {
        this.runningTitle = runningTitle;
        this.nameInParentMenu = nameInParentMenu;
        this.viewConfig = viewConfig;
    }

    public abstract void display();
    
    protected void onBack() {

    }
    
    protected void onQuit() {
        this.println(this.viewConfig.getQuitMessage());
    }
    
    protected void goBack() {
  
        if (this.parentView != null) {
            this.onBack();

        if(this.parentView instanceof MenuView){
                this.parentView.display();
            }
        }
        
        else {
            this.onQuit();
            System.exit(0);
        }
    }

    protected void pause() {
        this.print(this.viewConfig.getPauseMessage());
        this.keyboard.nextLine();
    }

    protected boolean confirmDialog(String warningMessage) {
        String input = this.prompt(warningMessage + this.viewConfig.getConfirmOption(), String.class);
        input = input.replace("\n", "");
        boolean confirmed = this.viewConfig.getConfirmValidator().isValid(input);
        if (!confirmed) {
            this.actionCanceled();
        }
        return confirmed;
    }

    protected void actionCanceled() {
        this.println(this.viewConfig.getActionCanceledMessage());
    }
    
    
    protected void actionSuccessful() {
        this.println(this.viewConfig.getActionSuccessfulMessage());
    }

    protected void actionFailed() {
        this.println(this.viewConfig.getActionFailedMessage());
    }

    protected void print(Object o) {
        System.out.print(o);
    }

    protected void println(Object o) {
        System.out.println(o);
    }

    protected void println() {
        System.out.println();
    }

    protected <T> T prompt(String message, Class<T> expectedClass) {
        return this.prompt(message, expectedClass, null);
    }
    
    
    protected <T> T prompt(String message, Class<T> expectedClass, Validator<T> validator) {
        boolean isValid = false;
        Object input = null;
        T output = null;
        this.print(message);
        while (!isValid) {
            try {
                if (expectedClass == Integer.class) {
                    input = keyboard.nextInt();
                } else if (expectedClass == Double.class) {
                    input = keyboard.nextDouble();
                } else if (expectedClass == String.class) {
                    input = keyboard.nextLine();
                } else if (expectedClass == Byte.class) {
                    input = keyboard.nextByte();
                } else if (expectedClass == BigDecimal.class) {
                    input = keyboard.nextBigDecimal();
                } else if (expectedClass == BigInteger.class) {
                    input = keyboard.nextBigInteger();
                } else if (expectedClass == Boolean.class) {
                    input = keyboard.nextBoolean();
                } else if (expectedClass == Float.class) {
                    input = keyboard.nextFloat();
                } else if (expectedClass == Long.class) {
                    input = keyboard.nextLong();
                } else if (expectedClass == Short.class) {
                    input = keyboard.nextShort();
                }

                output = expectedClass.cast(input);
                isValid = validator == null || validator.isValid(output);
            } catch (InputMismatchException e) {
            	
            } finally {
                if (expectedClass != String.class) {
                    keyboard.nextLine();
                }
                if(!isValid){
                    this.print(this.viewConfig.getInputErrorMessage());
                }
            }
        }
        return output;
    }


    public AbstractView getParentView() {
        return parentView;
    }

    public void setParentView(AbstractView parentView) {
        this.parentView = parentView;
    }

    public String getRunningTitle() {
        return runningTitle;
    }

    public void setRunningTitle(String runningTitle) {
        this.runningTitle = runningTitle;
    }

    public String getNameInParentMenu() {
        return nameInParentMenu;
    }

    public void setNameInParentMenu(String nameInParentMenu) {
        this.nameInParentMenu = nameInParentMenu;
    }

    public ViewConfig getViewConfig() {
        return viewConfig;
    }

    public void setViewConfig(ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
    }
}
