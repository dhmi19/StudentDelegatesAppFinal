package com.example.dhruvmittal.studentdelegatesapp.databinding;
import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CanteenOptionPageActivity1Binding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.CanteenTitleText1, 11);
        sViewsWithIds.put(R.id.CanteenQuestion1Label, 12);
        sViewsWithIds.put(R.id.CanteenQuestion2Label, 13);
        sViewsWithIds.put(R.id.CanteenQuestion3Label, 14);
        sViewsWithIds.put(R.id.CanteenNextPageButton, 15);
        sViewsWithIds.put(R.id.CanteenLogOutButton1, 16);
        sViewsWithIds.put(R.id.CanteenMenuButton1, 17);
    }
    // views
    @NonNull
    public final android.widget.CheckBox CanteenAnswer1A;
    @NonNull
    public final android.widget.CheckBox CanteenAnswer1B;
    @NonNull
    public final android.widget.CheckBox CanteenAnswer1C;
    @NonNull
    public final android.widget.CheckBox CanteenAnswer1D;
    @NonNull
    public final android.widget.CheckBox CanteenAnswer2A;
    @NonNull
    public final android.widget.CheckBox CanteenAnswer2B;
    @NonNull
    public final android.widget.CheckBox CanteenAnswer2C;
    @NonNull
    public final android.widget.CheckBox CanteenAnswer2D;
    @NonNull
    public final android.widget.CheckBox CanteenAnswer3A;
    @NonNull
    public final android.widget.CheckBox CanteenAnswer3B;
    @NonNull
    public final android.widget.Button CanteenLogOutButton1;
    @NonNull
    public final android.widget.Button CanteenMenuButton1;
    @NonNull
    public final android.widget.Button CanteenNextPageButton;
    @NonNull
    public final android.widget.TextView CanteenQuestion1Label;
    @NonNull
    public final android.widget.TextView CanteenQuestion2Label;
    @NonNull
    public final android.widget.TextView CanteenQuestion3Label;
    @NonNull
    public final android.widget.TextView CanteenTitleText1;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    @Nullable
    private com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 mActivity;
    @Nullable
    private com.example.dhruvmittal.studentdelegatesapp.model.Feedback mFeedback;
    @Nullable
    private final android.view.View.OnClickListener mCallback15;
    @Nullable
    private final android.view.View.OnClickListener mCallback16;
    @Nullable
    private final android.view.View.OnClickListener mCallback13;
    @Nullable
    private final android.view.View.OnClickListener mCallback14;
    @Nullable
    private final android.view.View.OnClickListener mCallback19;
    @Nullable
    private final android.view.View.OnClickListener mCallback12;
    @Nullable
    private final android.view.View.OnClickListener mCallback17;
    @Nullable
    private final android.view.View.OnClickListener mCallback21;
    @Nullable
    private final android.view.View.OnClickListener mCallback20;
    @Nullable
    private final android.view.View.OnClickListener mCallback18;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CanteenOptionPageActivity1Binding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds);
        this.CanteenAnswer1A = (android.widget.CheckBox) bindings[1];
        this.CanteenAnswer1A.setTag(null);
        this.CanteenAnswer1B = (android.widget.CheckBox) bindings[2];
        this.CanteenAnswer1B.setTag(null);
        this.CanteenAnswer1C = (android.widget.CheckBox) bindings[3];
        this.CanteenAnswer1C.setTag(null);
        this.CanteenAnswer1D = (android.widget.CheckBox) bindings[4];
        this.CanteenAnswer1D.setTag(null);
        this.CanteenAnswer2A = (android.widget.CheckBox) bindings[5];
        this.CanteenAnswer2A.setTag(null);
        this.CanteenAnswer2B = (android.widget.CheckBox) bindings[6];
        this.CanteenAnswer2B.setTag(null);
        this.CanteenAnswer2C = (android.widget.CheckBox) bindings[7];
        this.CanteenAnswer2C.setTag(null);
        this.CanteenAnswer2D = (android.widget.CheckBox) bindings[8];
        this.CanteenAnswer2D.setTag(null);
        this.CanteenAnswer3A = (android.widget.CheckBox) bindings[9];
        this.CanteenAnswer3A.setTag(null);
        this.CanteenAnswer3B = (android.widget.CheckBox) bindings[10];
        this.CanteenAnswer3B.setTag(null);
        this.CanteenLogOutButton1 = (android.widget.Button) bindings[16];
        this.CanteenMenuButton1 = (android.widget.Button) bindings[17];
        this.CanteenNextPageButton = (android.widget.Button) bindings[15];
        this.CanteenQuestion1Label = (android.widget.TextView) bindings[12];
        this.CanteenQuestion2Label = (android.widget.TextView) bindings[13];
        this.CanteenQuestion3Label = (android.widget.TextView) bindings[14];
        this.CanteenTitleText1 = (android.widget.TextView) bindings[11];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback15 = new android.databinding.generated.callback.OnClickListener(this, 4);
        mCallback16 = new android.databinding.generated.callback.OnClickListener(this, 5);
        mCallback13 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback14 = new android.databinding.generated.callback.OnClickListener(this, 3);
        mCallback19 = new android.databinding.generated.callback.OnClickListener(this, 8);
        mCallback12 = new android.databinding.generated.callback.OnClickListener(this, 1);
        mCallback17 = new android.databinding.generated.callback.OnClickListener(this, 6);
        mCallback21 = new android.databinding.generated.callback.OnClickListener(this, 10);
        mCallback20 = new android.databinding.generated.callback.OnClickListener(this, 9);
        mCallback18 = new android.databinding.generated.callback.OnClickListener(this, 7);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
            setActivity((com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1) variable);
        }
        else if (BR.feedback == variableId) {
            setFeedback((com.example.dhruvmittal.studentdelegatesapp.model.Feedback) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setActivity(@Nullable com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 Activity) {
        this.mActivity = Activity;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.activity);
        super.requestRebind();
    }
    @Nullable
    public com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 getActivity() {
        return mActivity;
    }
    public void setFeedback(@Nullable com.example.dhruvmittal.studentdelegatesapp.model.Feedback Feedback) {
        this.mFeedback = Feedback;
    }
    @Nullable
    public com.example.dhruvmittal.studentdelegatesapp.model.Feedback getFeedback() {
        return mFeedback;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeFeedback((com.example.dhruvmittal.studentdelegatesapp.model.Feedback) object, fieldId);
        }
        return false;
    }
    private boolean onChangeFeedback(com.example.dhruvmittal.studentdelegatesapp.model.Feedback Feedback, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.CanteenAnswer1A.setOnClickListener(mCallback12);
            this.CanteenAnswer1B.setOnClickListener(mCallback13);
            this.CanteenAnswer1C.setOnClickListener(mCallback14);
            this.CanteenAnswer1D.setOnClickListener(mCallback15);
            this.CanteenAnswer2A.setOnClickListener(mCallback16);
            this.CanteenAnswer2B.setOnClickListener(mCallback17);
            this.CanteenAnswer2C.setOnClickListener(mCallback18);
            this.CanteenAnswer2D.setOnClickListener(mCallback19);
            this.CanteenAnswer3A.setOnClickListener(mCallback20);
            this.CanteenAnswer3B.setOnClickListener(mCallback21);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.onCheckboxQ1Checked();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.onCheckboxQ2Checked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.onCheckboxQ1Checked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.onCheckboxQ1Checked();
                }
                break;
            }
            case 8: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.onCheckboxQ2Checked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.onCheckboxQ1Checked();
                }
                break;
            }
            case 6: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.onCheckboxQ2Checked();
                }
                break;
            }
            case 10: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.onCheckboxQ3Checked();
                }
                break;
            }
            case 9: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.onCheckboxQ3Checked();
                }
                break;
            }
            case 7: {
                // localize variables for thread safety
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // activity
                com.example.dhruvmittal.studentdelegatesapp.activity.CanteenOptionPageActivity1 activity = mActivity;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {


                    activity.onCheckboxQ2Checked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static CanteenOptionPageActivity1Binding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CanteenOptionPageActivity1Binding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<CanteenOptionPageActivity1Binding>inflate(inflater, com.example.dhruvmittal.studentdelegatesapp.R.layout.canteen_option_page_activity_1, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static CanteenOptionPageActivity1Binding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CanteenOptionPageActivity1Binding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.dhruvmittal.studentdelegatesapp.R.layout.canteen_option_page_activity_1, null, false), bindingComponent);
    }
    @NonNull
    public static CanteenOptionPageActivity1Binding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CanteenOptionPageActivity1Binding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/canteen_option_page_activity_1_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new CanteenOptionPageActivity1Binding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): feedback
        flag 1 (0x2L): activity
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}