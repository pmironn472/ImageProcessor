package processor;


import com.twelvemonkeys.image.*;
import config.ConfigurationProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {

    private ConfigurationProvider cp;

    public ImageProcessor() {

    }

    public ImageProcessor(ConfigurationProvider cp) {
        this.cp = cp;
    }


    public void transfortm(String FileName) throws IOException {
        BufferedImage bio = ImageIO.read(new File(cp.get("path.original") + FileName));


        BufferedImageOp resampler =  new ResampleOp(200, 200, ResampleOp.FILTER_LANCZOS);

        BufferedImage bir = resampler.filter(bio, null);


        ImageIO.write(bir, "jpeg", new File(cp.get("path.processed") + FileName));
    }

    public void setConfigurationProvider(ConfigurationProvider cp){
        this.cp = cp;
    }
}
