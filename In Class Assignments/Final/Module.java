public abstract class Module {
    
    // protected means public to its children but private to everyone else
    protected Bomb bomb;
    protected BombGUI gui;
    protected boolean isDefused;

    // data type "Module"
    public Module(Bomb bomb, BombGUI gui) {
        this.bomb = bomb;
        this.gui = gui;
        this.isDefused = false;
    }

    // A normal method that all children will share exactly as is
    public boolean getIsDefused() {
        return isDefused;
    }

    // kinda like an interface. it just lets me call handleInput on a module that isnt typed as 
    // a specific module:

    // Module testModule = new Module(...);
    // testModule.handleInput(...);
    // will not throw any errors, because the module class pushes this method down to its 
    // children methods and lets them make their own versions of it WITHOUT OVERRIDING IT.
    // its basically like which one of you does this belong to, then gives the input to it.
    public abstract void start();
    public abstract void handleInput(String input);
}