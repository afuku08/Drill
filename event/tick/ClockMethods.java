public  interface ClockMethods {
    static final int START_CLOCK   = 1;
    static final int STOP_CLOCK    = 2;
    static final int TICK_CLOCK    = 3;
    static final int RESET_CLOCK   = 4;
    static final int DEFAULT_CLOCK = 5;

    /* ���v�̓������J�n������ */
    public void startClock();

    /* ���v�̓������~������ */
    public void stopClock();

    /* �C�x���g���󂯂Č��ݎ�����i�߂� */
    public void tickClock();

    /* ���v�����Z�b�g����i0��0��0�b�ɂ��킹��j */
    public void resetClock();

    /* ���v���V�X�e�������ɂ��킹�� */
    public void defaultClock();

    /* ���v�̎�����^����ꂽ�����b�ɂ��킹�� */
    public void setTime(Time t);

    /* ���ݎ��������o�� */
    public void getTime(Time t);

    /* ���v�̕\���p�I�u�W�F�N�g��ݒ肷�� */
    public void setViewer(Object viewer);
}