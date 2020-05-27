package cz.knourekdaniel.TUL;

public class CompareBySpeed implements ComparatorTemplate {
    @Override
    public boolean isBigger(Object o1, Object o2) {
        return ((Hurrican)o1).getSpeed()<((Hurrican)o2).getSpeed();
    }
}