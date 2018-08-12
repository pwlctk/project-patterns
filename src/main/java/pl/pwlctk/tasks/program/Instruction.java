package pl.pwlctk.tasks.program;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class Instruction {
    private Long address;
    private String type, arguments;
}
