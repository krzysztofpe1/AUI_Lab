package org.AUI_Lab.client.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchClientRequest {
    private String name;
    private String surname;
    private String clientAddress;
}
