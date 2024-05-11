package com.crio.CoderHack.coderhack.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {


   private BigInteger UserID;
   private  String username ;



}
