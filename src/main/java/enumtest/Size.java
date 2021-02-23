package enumtest;

/**
 * Created by hyq on 2021/1/4 17:52.
 */
public enum Size {
    SMALL("S", "小号") {
        @Override
        public void onChosen() {
            System.out.println("chosen small");
        }
    }, MEDIUM("M", "中号") {
        @Override
        public void onChosen() {
            System.out.println("chosen medium");
        }
    }, LARGE("L", "大号") {
        @Override
        public void onChosen() {
            System.out.println("chosen large");
        }
    };

    private String abbr;
    private String title;

    Size(String abbr, String title) {
        this.abbr = abbr;
        this.title = title;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getTitle() {
        return title;
    }

    public static Size fromAbbr(String abbr) {
        for (Size size : Size.values()) {
            if (size.getAbbr().equals(abbr)) {
                return size;
            }
        }
        return null;
    }

    public abstract void onChosen();
}
