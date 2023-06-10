package net.thenextlvl.cloud.velocity.template;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.thenextlvl.cloud.template.Template;

import java.io.File;

@Getter
@RequiredArgsConstructor
public class VelocityTemplate implements Template {
    private final String name;
    private final File container;
}
