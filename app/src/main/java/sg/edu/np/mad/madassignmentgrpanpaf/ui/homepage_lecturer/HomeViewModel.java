package sg.edu.np.mad.madassignmentgrpanpaf.ui.homepage_lecturer;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();

        //mText.setValue("Hello");
    }

    public LiveData<String> getText() {
        return mText;
    }
}