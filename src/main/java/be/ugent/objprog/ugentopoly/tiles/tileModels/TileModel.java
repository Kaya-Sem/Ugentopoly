package be.ugent.objprog.ugentopoly.tiles.tileModels;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TileModel implements Observable {

    protected final String id;
    protected final int position;

    protected final List<InvalidationListener> listenerList;

    public TileModel(String id, int position){
        this.id = id;
        this.position = position;
        listenerList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listenerList.add(listener);
        // NEEDSLOG
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listenerList.remove(listener);
        // NEEDSLOG
    }

    protected void fireInvalidationEvent() {
        for (InvalidationListener listener : this.listenerList) {
            listener.invalidated(this);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName()).append(" {");
        Field[] fields = getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                sb.append(field.getName()).append(": ").append(field.get(this)).append(", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (sb.length() > 2) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("}");
        return sb.toString();
    }

}