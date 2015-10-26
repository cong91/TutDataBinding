package congnt.framgia.com.tutdatabinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.view.View;

import static congnt.framgia.com.tutdatabinding.PhonewordUtils.toNumber;

public class PhonewordViewModel extends BaseObservable {
    private final String TAG = PhonewordViewModel.class.getName();
    private boolean mIsTranslated = false;
    private String mPhoneNumber = "";
    private String mPhoneWord = "";
    private String mCallButtonText = "Call";

    @Bindable
    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    @Bindable
    public String getCallButtonText() {
        return mCallButtonText;
    }

    @Bindable
    public boolean getIsTranslated() {
        return mIsTranslated;
    }

    @Bindable
    public String getPhoneWord() {
        return mPhoneWord;
    }


    public void setPhoneWord(String phoneWord) {
        mPhoneWord = phoneWord;
        notifyPropertyChanged(congnt.framgia.com.tutdatabinding.BR.phoneWord);
    }

    public void translatePhoneWord() {
        mPhoneNumber = toNumber(mPhoneWord);

        if (TextUtils.isEmpty(mPhoneNumber)) {
            mCallButtonText = "Call";
            mIsTranslated = false;
        } else {
            mIsTranslated = true;
            mCallButtonText = "Call " + mPhoneNumber + "?";
        }
        notifyPropertyChanged(congnt.framgia.com.tutdatabinding.BR.phoneNumber);
        notifyPropertyChanged(congnt.framgia.com.tutdatabinding.BR.isTranslated);
        notifyPropertyChanged(congnt.framgia.com.tutdatabinding.BR.callButtonText);
    }

    public void onTranslate(View v) {
        translatePhoneWord();
    }
}
