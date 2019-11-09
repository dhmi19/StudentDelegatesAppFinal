package com.example.dhruvmittal.studentdelegatesapp.databinding;
import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LogInActivityBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.titleLogIn, 5);
        sViewsWithIds.put(R.id.textView4, 6);
    }
    // views
    @NonNull
    public final android.widget.Button btnLogin;
    @NonNull
    public final android.widget.Button btnSignUp;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.widget.EditText passwordLogIn;
    @NonNull
    public final android.widget.TextView textView4;
    @NonNull
    public final android.widget.TextView titleLogIn;
    @NonNull
    public final android.widget.EditText userNameLogIn;
    // variables
    @Nullable
    private com.example.dhruvmittal.studentdelegatesapp.activity.LogInActivity mActivity;
    @Nullable
    private com.example.dhruvmittal.studentdelegatesapp.model.User mUser;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener passwordLogInandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.password
            //         is user.setPassword((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(passwordLogIn);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.example.dhruvmittal.studentdelegatesapp.model.User user = mUser;
            // user.password
            java.lang.String userPassword = null;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setPassword(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener userNameLogInandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.username
            //         is user.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(userNameLogIn);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.example.dhruvmittal.studentdelegatesapp.model.User user = mUser;
            // user.username
            java.lang.String userUsername = null;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setUsername(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public LogInActivityBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.btnLogin = (android.widget.Button) bindings[3];
        this.btnLogin.setTag(null);
        this.btnSignUp = (android.widget.Button) bindings[4];
        this.btnSignUp.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.passwordLogIn = (android.widget.EditText) bindings[2];
        this.passwordLogIn.setTag(null);
        this.textView4 = (android.widget.TextView) bindings[6];
        this.titleLogIn = (android.widget.TextView) bindings[5];
        this.userNameLogIn = (android.widget.EditText) bindings[1];
        this.userNameLogIn.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback1 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.activity == variableId) {
            setActivity((com.example.dhruvmittal.studentdelegatesapp.activity.LogInActivity) variable);
        }
        else if (BR.user == variableId) {
            setUser((com.example.dhruvmittal.studentdelegatesapp.model.User) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setActivity(@Nullable com.example.dhruvmittal.studentdelegatesapp.activity.LogInActivity Activity) {
        this.mActivity = Activity;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.activity);
        super.requestRebind();
    }
    @Nullable
    public com.example.dhruvmittal.studentdelegatesapp.activity.LogInActivity getActivity() {
        return mActivity;
    }
    public void setUser(@Nullable com.example.dhruvmittal.studentdelegatesapp.model.User User) {
        updateRegistration(0, User);
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }
    @Nullable
    public com.example.dhruvmittal.studentdelegatesapp.model.User getUser() {
        return mUser;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeUser((com.example.dhruvmittal.studentdelegatesapp.model.User) object, fieldId);
        }
        return false;
    }
    private boolean onChangeUser(com.example.dhruvmittal.studentdelegatesapp.model.User User, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.username) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.password) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String userUsername = null;
        com.example.dhruvmittal.studentdelegatesapp.activity.LogInActivity activity = mActivity;
        java.lang.String userPassword = null;
        com.example.dhruvmittal.studentdelegatesapp.model.User user = mUser;

        if ((dirtyFlags & 0x1dL) != 0) {


            if ((dirtyFlags & 0x15L) != 0) {

                    if (user != null) {
                        // read user.username
                        userUsername = user.getUsername();
                    }
            }
            if ((dirtyFlags & 0x19L) != 0) {

                    if (user != null) {
                        // read user.password
                        userPassword = user.getPassword();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.btnLogin.setOnClickListener(mCallback1);
            this.btnSignUp.setOnClickListener(mCallback2);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.passwordLogIn, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, passwordLogInandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.userNameLogIn, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, userNameLogInandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.passwordLogIn, userPassword);
        }
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.userNameLogIn, userUsername);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.LogInActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openSignUpPage();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // user
                com.example.dhruvmittal.studentdelegatesapp.model.User user = mUser;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.LogInActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {



                    activity.onLoginButtonClick(user);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static LogInActivityBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static LogInActivityBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<LogInActivityBinding>inflate(inflater, com.example.dhruvmittal.studentdelegatesapp.R.layout.log_in_activity, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static LogInActivityBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static LogInActivityBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.dhruvmittal.studentdelegatesapp.R.layout.log_in_activity, null, false), bindingComponent);
    }
    @NonNull
    public static LogInActivityBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static LogInActivityBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/log_in_activity_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new LogInActivityBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): user
        flag 1 (0x2L): activity
        flag 2 (0x3L): user.username
        flag 3 (0x4L): user.password
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}