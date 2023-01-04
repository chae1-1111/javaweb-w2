package org.zerock.w2.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String userid;
    private String userpw;
    private String username;
    private String uuid;
}
