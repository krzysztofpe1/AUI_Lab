package org.AUI_Lab.AUI_Lab.client.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetClientResponse {
    private UUID id;
    private String name;
    private String surname;
    private String clientAddress;
}
