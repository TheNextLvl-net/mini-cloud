package minicloud.client.template;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minicloud.api.object.Identifier;
import minicloud.api.template.Template;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.concurrent.CompletableFuture;

@Getter
@RequiredArgsConstructor
public class ClientTemplate implements Template {
    private final Identifier name;
    private final String[] command;
    private final int size;
    private final DateFormat createdAt;
    private final DateFormat updatedAt;

    @Override
    public CompletableFuture<Template> updateFiles(FileInputStream fileInput) {
        return null;
    }

    @Override
    public FileOutputStream downloadFiles(File destination) {
        return null;
    }
}
