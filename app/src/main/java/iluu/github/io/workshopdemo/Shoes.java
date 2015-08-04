package iluu.github.io.workshopdemo;

import android.text.TextUtils;

public class Shoes {
    public static final int INVALID_SIZE = -1;

    public final String brand;
    public final int size;

    public Shoes(String brand, int size) {
        this.brand = brand;
        this.size = size;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(brand) && size != INVALID_SIZE;
    }

    @Override
    public String toString() {
        return brand + ' ' +'[' + size + ']';
    }
}
