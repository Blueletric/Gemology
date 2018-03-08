package blue.technicallygems.utils;

import blue.technicallygems.TechnicallyGems;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
    private static final ThreadLocal<HashSet<String>> one_time_strings_set = new ThreadLocal<HashSet<String>>() {
        @Override
        protected HashSet<String> initialValue() {
            return new Hashset<>();
        }
    };

    public static ArrayList<String> getOneTimeStrings() {
        return one_time_strings;
    }

    private static final ArrayList<String> one_time_strings = new ArrayList<>();

    public static Logger logger = LogManager.getLogger(TechnicallyGems.MODID);
    public static boolean isDeObf = false;

    static {
        try {
            net.minecraft.world.World.class.getMethod("getBlockState", BlockPos.class);
            isDeObf = true;
        } catch (Throwable ex) {
            isDeObf = false;
        }
    }

    SimpleDateFormat format = new SimpleDateFormat();

    public static void debug(Object info, Object... info2) {
        if(isDeObf) {
            String temp = "Debug: " + info;
            for (Object t : info2)
                temp = temp + " " + t;

            logger.info(info);
        }
    }

    public static void info(Object info, Object... info2) {
        String temp = "" + info;
        for (Object t : info2)
            temp = temp + " " + t;

        logger.info(info);
    }

    public static void fine(Object info, Object... info2) {
        String temp = "" + info;
        for (Object t : info2)
            temp = temp + " " + t;

        logger.debug(temp);
    }

    public static void errorThrowable(String message, Throwable t) {
        logger.error(message, t);
    }

    public static void error(Object info, Object... info2) {
        String temp = "" + info;
        for (Object t : info2)
            temp = temp + " " + t;

        logger.error(info);
    }

    public static void oneTimeInfo(String string) {
        if (one_time_strings_set.get().add(string)) {
            synchronized (one_time_strings) {
                String now = (new SimpleDateFormat("HH.mm.ss")).format(new Date());
                one_time_strings.add("[" + Thread.currentThread().getName() + "](" + now + "): " + string);
            }
            fine("OTL: " + string);
        }
    }
}

