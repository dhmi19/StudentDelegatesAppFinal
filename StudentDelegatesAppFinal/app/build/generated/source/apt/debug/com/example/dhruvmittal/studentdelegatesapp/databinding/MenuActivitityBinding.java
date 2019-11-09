package com.example.dhruvmittal.studentdelegatesapp.databinding;
import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MenuActivitityBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textView8, 10);
        sViewsWithIds.put(R.id.DisplayUsername, 11);
    }
    // views
    @NonNull
    public final android.widget.Button AccountButton;
    @NonNull
    public final android.widget.Button CanteenButton;
    @NonNull
    public final android.widget.TextView DisplayUsername;
    @NonNull
    public final android.widget.Button ECAButton;
    @NonNull
    public final android.widget.Button FreeTimeButton;
    @NonNull
    public final android.widget.Button LogOutButton;
    @NonNull
    public final android.widget.Button ReportButton;
    @NonNull
    public final android.widget.Button ReviewHistoryButton;
    @NonNull
    public final android.widget.Button SubjectButton;
    @NonNull
    public final android.widget.Button TeachersButton;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.widget.TextView textView8;
    // variables
    @Nullable
    private com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity mActivity;
    @Nullable
    private final android.view.View.OnClickListener mCallback9;
    @Nullable
    private final android.view.View.OnClickListener mCallback8;
    @Nullable
    private final android.view.View.OnClickListener mCallback7;
    @Nullable
    private final android.view.View.OnClickListener mCallback11;
    @Nullable
    private final android.view.View.OnClickListener mCallback6;
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback10;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MenuActivitityBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds);
        this.AccountButton = (android.widget.Button) bindings[8];
        this.AccountButton.setTag(null);
        this.CanteenButton = (android.widget.Button) bindings[1];
        this.CanteenButton.setTag(null);
        this.DisplayUsername = (android.widget.TextView) bindings[11];
        this.ECAButton = (android.widget.Button) bindings[3];
        this.ECAButton.setTag(null);
        this.FreeTimeButton = (android.widget.Button) bindings[5];
        this.FreeTimeButton.setTag(null);
        this.LogOutButton = (android.widget.Button) bindings[6];
        this.LogOutButton.setTag(null);
        this.ReportButton = (android.widget.Button) bindings[9];
        this.ReportButton.setTag(null);
        this.ReviewHistoryButton = (android.widget.Button) bindings[7];
        this.ReviewHistoryButton.setTag(null);
        this.SubjectButton = (android.widget.Button) bindings[2];
        this.SubjectButton.setTag(null);
        this.TeachersButton = (android.widget.Button) bindings[4];
        this.TeachersButton.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textView8 = (android.widget.TextView) bindings[10];
        setRootTag(root);
        // listeners
        mCallback9 = new android.databinding.generated.callback.OnClickListener(this, 7);
        mCallback8 = new android.databinding.generated.callback.OnClickListener(this, 6);
        mCallback7 = new android.databinding.generated.callback.OnClickListener(this, 5);
        mCallback11 = new android.databinding.generated.callback.OnClickListener(this, 9);
        mCallback6 = new android.databinding.generated.callback.OnClickListener(this, 4);
        mCallback5 = new android.databinding.generated.callback.OnClickListener(this, 3);
        mCallback4 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback10 = new android.databinding.generated.callback.OnClickListener(this, 8);
        mCallback3 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            setActivity((com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setActivity(@Nullable com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity Activity) {
        this.mActivity = Activity;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.activity);
        super.requestRebind();
    }
    @Nullable
    public com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity getActivity() {
        return mActivity;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity activity = mActivity;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.AccountButton.setOnClickListener(mCallback10);
            this.CanteenButton.setOnClickListener(mCallback3);
            this.ECAButton.setOnClickListener(mCallback5);
            this.FreeTimeButton.setOnClickListener(mCallback7);
            this.LogOutButton.setOnClickListener(mCallback8);
            this.ReportButton.setOnClickListener(mCallback11);
            this.ReviewHistoryButton.setOnClickListener(mCallback9);
            this.SubjectButton.setOnClickListener(mCallback4);
            this.TeachersButton.setOnClickListener(mCallback6);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 7: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openHistoryPage();
                }
                break;
            }
            case 6: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openLogInPage();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openFreePeriodPage();
                }
                break;
            }
            case 9: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openReportPage();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openTeacherPage();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openECAPage();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openSubjectPage();
                }
                break;
            }
            case 8: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openUpdateAccountPage();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.openCanteenPage();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static MenuActivitityBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static MenuActivitityBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<MenuActivitityBinding>inflate(inflater, com.example.dhruvmittal.studentdelegatesapp.R.layout.menu_activitity, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static MenuActivitityBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static MenuActivitityBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.dhruvmittal.studentdelegatesapp.R.layout.menu_activitity, null, false), bindingComponent);
    }
    @NonNull
    public static MenuActivitityBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static MenuActivitityBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/menu_activitity_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new MenuActivitityBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): activity
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}