package org.fixated.models.request.add;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddTempUserRequest extends WorkerAddRequest {

    @JsonCreator
    public AddTempUserRequest(
            @JsonProperty("user_name") String username,
            @JsonProperty("role") String role,
            @JsonProperty("worker_id") String workerID,
            @JsonProperty("branch_code") String branchCode
    ){
        super(username,null,null,role,null,workerID,branchCode);
    }
}
