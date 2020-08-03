package net.lishaoy.serializabledemo.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Course implements Parcelable {

    private static final String TAG = "Course";
    private String name;
    private float score;

    public Course() {

    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public Course(Parcel in) {
        this.name = in.readString();
        this.score = in.readFloat();
    }
    // 反序列化，将 Parcel 对象转换为 Parcelable
    public static final Creator<Course> CREATOR = new Creator<Course>() {
        //反序列化的方法，将Parcel还原成Java对象
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }
        //提供给外部类反序列化这个数组使用。
        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public Course(String name, float score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    // 序列化，将对象转换成一个 Parcel 对象
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeFloat(this.score);
    }

    public static void runParcel() {
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(6);
        parcel.writeInt(66);

        byte[] bytes = parcel.marshall();
        parcel.setDataCapacity(0);
        parcel.recycle();
        parcel = Parcel.obtain();
        parcel.unmarshall(bytes,0,bytes.length);
        int size = parcel.dataSize();
        for (int i = 0; i < size; i++) {
            parcel.setDataPosition(i);
            Log.i(TAG, "runParcel: " + parcel.readInt());
        }
        parcel.recycle();
    }

}
