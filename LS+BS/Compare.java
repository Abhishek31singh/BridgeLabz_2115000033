class Compare{
    public void compareStringBufferStringBuilder() {
        int n = 1000000;
        String str = "hello";
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        startTime = System.nanoTime();
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbr.append(str);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("StringBuffer time: " + stringBufferTime + " ns");
        System.out.println("StringBuilder time: " + stringBuilderTime + " ns");
    }
    public static void main(String[] args) {
        new Compare().compareStringBufferStringBuilder();
    }
}
