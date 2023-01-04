package org.zerock.w2.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

    private String userid;
    private String userpw;
    private String username;
    private String uuid;

}
