# IF2230-Arkavquarium-II
    /**
     * default constructor.
     * @param x location x
     */
    public Food(double x) {
        set_y(Constants.SCREEN_TOP);
        set_x(x);
        food_count += 1;
        set_id(food_count);
        set_speed(Constants.FOOD_MOVEMENT_SPD);

        this.set_image(ImageCollection.food);

        this.change_position(get_x(), get_y());
    }

    /**
     * getter food_id.
     * @return food_id
     */
    public int get_id() {
        return this.food_id;
    }
