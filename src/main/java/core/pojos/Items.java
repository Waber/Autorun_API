package core.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class Items {

    @JsonProperty("_id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("locale")
    private List<String> locale;
    @JsonProperty("is_verified")
    private Boolean isVerified;
    @JsonProperty("department_id")
    private Integer departmentId;

}
