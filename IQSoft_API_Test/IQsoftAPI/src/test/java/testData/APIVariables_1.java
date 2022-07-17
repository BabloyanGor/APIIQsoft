package testData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class APIVariables_1 {
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("data")
    @Expose
    private String data;

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
