package tn.itskills.android.sharedpreferences.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by adnenhamdouni on 07/05/2016.
 */
public class MyPreferencesHelper {

    private static volatile MyPreferencesHelper mInstance = null;

    private static final String PREFERENCES_FILE_NAME = "my_preferences";

    private Context mContext;

    /*
     * MY PREFERENCES
     */
    private static final String PREFERENCES_STATUS = "is_saved";
    private static final String PREFERENCES_NAME = "name";
    private static final String PREFERENCES_ID = "id";


    private static final long DEFAULT_ID = 0;
    private static final String DEFAULT_NAME = "";
    private static final boolean DEFAULT_STATUS = false;

    /*
     * shared preferences
     */

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mPreferencesEditor;

    public static MyPreferencesHelper getInstance(Context context) {

        synchronized (MyPreferencesHelper.class) {
            if (mInstance == null) {
                mInstance = new MyPreferencesHelper(context);
            }
        }
        return mInstance;
    }

    /**
     * private constructor
     *
     * @param context
     */
    private MyPreferencesHelper(Context context) {
        mContext = context;

        mPreferences = mContext.getSharedPreferences(
                PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        mPreferencesEditor = mPreferences.edit();
    }

    public static void reset() {
        mInstance = null;
    }

    /*
     * *****************************************************
     * ***************** my preferences ****************
     * *****************************************************
     */

    public boolean getStatus() {
        return mPreferences.getBoolean(PREFERENCES_STATUS, DEFAULT_STATUS);
    }

    public void setStatus(boolean isOpened) {
        mPreferencesEditor.putBoolean(PREFERENCES_STATUS, isOpened);
        mPreferencesEditor.commit();
    }

    public long getId() {
        return mPreferences.getLong(PREFERENCES_NAME, DEFAULT_ID);
    }

    public void setId(long id) {
        mPreferencesEditor.putLong(PREFERENCES_NAME, id);
        mPreferencesEditor.commit();
    }

    public String getName() {
        return mPreferences.getString(PREFERENCES_ID, DEFAULT_NAME);
    }

    public void setName(String name) {
        mPreferencesEditor.putString(PREFERENCES_ID, name);
        mPreferencesEditor.commit();
    }

}