
package android.databinding;
import com.example.dhruvmittal.studentdelegatesapp.BR;
class DataBinderMapperImpl extends android.databinding.DataBinderMapper {
    public DataBinderMapperImpl() {
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.example.dhruvmittal.studentdelegatesapp.R.layout.log_in_activity:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/log_in_activity_0".equals(tag)) {
                            return new com.example.dhruvmittal.studentdelegatesapp.databinding.LogInActivityBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for log_in_activity is invalid. Received: " + tag);
                }
                case com.example.dhruvmittal.studentdelegatesapp.R.layout.menu_activitity:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/menu_activitity_0".equals(tag)) {
                            return new com.example.dhruvmittal.studentdelegatesapp.databinding.MenuActivitityBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for menu_activitity is invalid. Received: " + tag);
                }
                case com.example.dhruvmittal.studentdelegatesapp.R.layout.canteen_option_page_activity_1:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/canteen_option_page_activity_1_0".equals(tag)) {
                            return new com.example.dhruvmittal.studentdelegatesapp.databinding.CanteenOptionPageActivity1Binding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for canteen_option_page_activity_1 is invalid. Received: " + tag);
                }
        }
        return null;
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    @Override
    public int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 1232715002: {
                if(tag.equals("layout/log_in_activity_0")) {
                    return com.example.dhruvmittal.studentdelegatesapp.R.layout.log_in_activity;
                }
                break;
            }
            case -1370097744: {
                if(tag.equals("layout/menu_activitity_0")) {
                    return com.example.dhruvmittal.studentdelegatesapp.R.layout.menu_activitity;
                }
                break;
            }
            case -1026060526: {
                if(tag.equals("layout/canteen_option_page_activity_1_0")) {
                    return com.example.dhruvmittal.studentdelegatesapp.R.layout.canteen_option_page_activity_1;
                }
                break;
            }
        }
        return 0;
    }
    @Override
    public String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"accessToken"
            ,"activity"
            ,"admin"
            ,"feedback"
            ,"password"
            ,"question1"
            ,"question2"
            ,"question3"
            ,"question4"
            ,"question5"
            ,"question6"
            ,"surveyId"
            ,"user"
            ,"username"
            ,"yearGroup"};
    }
}