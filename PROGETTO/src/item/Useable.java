package item;

import attackable.Robot;

public interface Useable<T extends Robot>{
           public void setOwner(T r);
           public T getOwner();
           
}
