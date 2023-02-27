package core.helpers;


import core.helpers.exception.FrameworkException;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileHelper {

    public static String readFile(String path) {
        try {

            String name = path;
            InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(name);

            String out = IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);
            return out;
        } catch (IOException e) {
            throw new FrameworkException("Some problem with file");
        }
    }


}
