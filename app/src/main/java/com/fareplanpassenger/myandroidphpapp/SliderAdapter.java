package com.fareplanpassenger.myandroidphpapp;
/**Add content and layout inflater variables
 * Create a constructor to pass context through it
 * Create arrays to store the values for our slider
 * override instantiateItem
 * override destroyItem*/
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) { // constructor
        this.context = context;
    }

    //Arrays
    public int [] slide_images ={
            R.drawable.week_one,
            R.drawable.week_two,
            R.drawable.week_three,
            R.drawable.week_four,
            R.drawable.week_five,
            R.drawable.week_six,
            R.drawable.week_seven,
            R.drawable.week_eight,
            R.drawable.week_nine,
            R.drawable.week_ten,
            R.drawable.week_eleven,
            R.drawable.week_twelve,
            R.drawable.week_thirteen,
            R.drawable.week_fourteen,
            R.drawable.week_fifteen,
            R.drawable.week_sixteen,
            R.drawable.week_seventeen,
            R.drawable.week_eighteen,
            R.drawable.week_nineteen,
            R.drawable.week_twenty,
            R.drawable.week_twenty_one,
            R.drawable.week_twenty_two,
            R.drawable.week_twenty_three,
            R.drawable.week_twenty_four,
            R.drawable.week_twenty_five,
            R.drawable.week_twenty_six,
            R.drawable.week_twenty_seven,
            R.drawable.week_twenty_eight,
            R.drawable.week_twenty_nine,
            R.drawable.week_thirty,
            R.drawable.week_thirty_one,
            R.drawable.week_thirty_two,
            R.drawable.week_thirty_three,
            R.drawable.week_thirty_five,
            R.drawable.week_thirty_nine,
            R.drawable.week_fourty,
    };
    public String[] slide_headings ={
            "WEEK 1",
            "WEEK 2",
            "WEEK 3",
            "WEEK 4",
            "WEEK 5",
            "WEEK 6",
            "WEEK 7",
            "WEEK 8",
            "WEEK 9",
            "WEEK 10",
            "WEEK 11",
            "WEEK 12",
            "WEEK 13",
            "WEEK 14",
            "WEEK 15",
            "WEEK 16",
            "WEEK 17",
            "WEEK 18",
            "WEEK 19",
            "WEEK 20",
            "WEEK 21",
            "WEEK 22",
            "WEEK 23",
            "WEEK 24",
            "WEEK 25",
            "WEEK 26",
            "WEEK 27",
            "WEEK 28",
            "WEEK 29",
            "WEEK 30",
            "WEEK 31",
            "WEEK 32",
            "WEEK 33",
            "WEEK 34 - 36",
            "WEEK 37 - 39",
            "WEEK 40",
    };
    public  String[] side_desc = {
            "1. Your pregnancy begins as your body gears up for ovulation and prepares for fertilization",
            "2. Somewhere between 100 million and 500 million sperm will be trying to boogie their way up your fallopian tubes to reach that single, solitary egg.Only about 200 of them will make it to end of the road.And only one will earn the right to do a little victory dance in the end of the road.And onlyone will earn the right to do a little victory dance in the end zone.",
            "3. You are in the fertilization and implantation stage.As sperm meets egg,fertilization occurs and your baby to be takes form as atiny group of cells.",
            "4. Once implanted, your baby starts to produce a hormone called human chorionic gonadotropin[hcg].\n" +
                    "This is the hormone that will be behind most of your pregnancy symptoms in the coming weeks and months.",
            "5. Yourr baby's heart and circu8latory system are developing, while your hcg hormone levels are now high enough to confirm your good news with a home pregnancy test.",
            "6. Babys face is forming- baby's face is taking shape.The eyes and ears begin to form well as well as an opening for the mouth.The heart has begun to pump blood and most of ther organs are well under construction.Buds form on the body that willbecome the arms and legs.",
            "7. The legs and arms are getting formed.Tongue and mouth also begin to be vshaped.The brain and face are developing rapidly, and nostrils and lenses of the eyes begin to form.",
            "8. An ultrasound done at this stage should show a fluttering heartbeat.\n" +
                    "Elbows begin to form in the arms and fingers start to develop.The leg buds begin to show feet with tiny notches for the toes.The face continues to change as the ears,eyes and the tip of the nose appear.\n" +
                    "Lungs,ears,eyes,upper lip and nose start to form.",
            "9. Your baby is busy building muscle and start moving in the womb.\n" +
                    "He is now beginning to look more 'baby shaped'. He has shoulders and elbows, and his hands,feet and limbs are growing particularly quicly.",
            "10. Separation of fingers and toes and the disappearance of the tail takes place.Most of the joints are formed now- elbow,wrist,knee,shoulder, and ankle as well as the hands,fingers,feet and toes.",
            "11. All of your baby's vital organs are now formed and fu8nctionin.So, the baby is now called a fetus.\n" +
                    "Ears  move toward their final position on the sides of the head.\n" +
                    "In an ultrasound you might be able to see your little baby flailing his or her amrs and legs.",
            "12. Fingers and toes have separated and hair and mails begin to grow.Your baby is able to swallow this week and practices on the amniotic fluid.Amniotic fluid begins to accumulate as the baby's kidneys begin to produce and excrete urine.The muscles in the intestinal walls begin to practice peristalsis-cintractiond within the intestines that digest food.\n" +
                    "Your baby's kidneys are functioning!After swallowing amniotic fluid,your baby will now be able to pass it out of the body as urine.",
            "13. Welcome to the 2nd trimester.\n" +
                    "The nose and lips are comletely formed.Your baby may also be able to put a thumb in his  or her mouth this week.\n" +
                    "By now, your baby's hands and feet are fully formed.It would be possible now to determine the baby's sex.",
            "14. The eyes and ears continue to move and develop, the neck is still getting longer, and the baby's chin no longer rests on his/her chest.The hands are becoming functional, and the baby is beginning to learn to move/use them.",
            "15. The baby skin is very thin and trasparent;you can can see blood vessels through the skin.Lanugo, a very fine hair, covers the body and will continue growing on the baby until around the 26th gestational week of pregnancy.",
            "16. The baby eyes and ears are moving into their final position.The legs are now longer than the arms, and s/he is moving those arms and legs frequently,especialluy since thre's still lots of room to move within the uterus.\n" +
                    "You may begin to feel movement as the baby's bones harden.",
            "17. The tiny heart is pumping as much as 25 quarts of blood a day!The reflexes are probably in place now as the baby sucks,swallows and blinks.",
            "18. Inside his her body,your baby is developing the stomach,intestine and coooooooooon.\n" +
                    "If your baby is a girl, her uterus and fallopian tubes are formed and in place.\n" +
                    "If your baby is a boy, his prostate gland is beginning to develop.",
            "19. Your uterus has reached or is just below your navel.\n" +
                    "You may no0w feel a bit unstable as your bellycontinues to expand,your center of gravity will shift.",
            "20. We are halfway through the pregnancy, and the baby has as much sleep and awake time as a newborn.The scalp hair begins to grow.",
            "21. The rapipgrowth phase begins to slow down this week.The heart grows stronger this week,and the legs are reaching their relative proportions.",
            "22. The eyelids and eyebrows are now formed, and the brain begins rapid growth.",
            "23. The body is becoming better proportioned each day, and the bones of the middle ear begin to harden.",
            "24. Your baby's daily workout routine includes moving the muscles in the fingers,toes,arms, and legs regularly.As a result, you may feel more forceful movements.",
            "25. The blood vessels of the lungs are developing and the nostrils begin to open.",
            "26. Baby can now hear your voice and your partner's when you are chatting with each other.Try to chat with your baby often.If in case your baby is born during this pregnancy week 26, he or she had 40% chance to survive with intensive care services.The lungs still need to fully mature.",
            "27. The brain continues its rapid growth, and the lungs continue to grow.Eyelids begin to open, and the retinas begin to form.\n" +
                    "WEEK",
            "28. The eyelids open, and the eyes are completely formed.If your baby is born  now, the chance of his or her to survive is 90%.",
            "29. The baby's head is in proportion to the rest of the body.Fat continues to accumulate under the skin.The brain can control primitive breathing and body temperature control, and the eyes can move in the sockets.The baby is becoming sensitive to light and sound.",
            "30. The eyelids open and close.Your baby should move at least 10 times in two hours.If your baby moves less,talk to your health care provider.",
            "31. The only major organ left to fully develop is the lungs.He or she is also swallowing amniotic fluid, which is completely replaced several times a day.",
            "32. The toenails are completely formed and the hair on the head continues to grow.\n" +
                    "The final touches are being placed on your baby masterpiece.Eyelashes,eyebrows, amd the hair on your baby's head are evident.",
            "33. Rapid brain growth has increased the baby's head size.Fat continues to accumulate.",
            "34 - 36. Baby is continuing to get bigger!\n" +
                    "The baby can open and close its eyes and follow light.",
            "37 - 39. Your baby is considered full-term!But your baby has not stopped growing yet.\n" +
                    "Fat is still accumulating.\n" +
                    "The pregnancy is reaching its final stage.",
            "40. In pregnancy week 40,the baby has been able to protect herself from difference in temperature thru building up fat under the skin.It will help to survive the temperature outside  your womb when the baby arrives in the world soon......\n" +
                    "After many weeks of anticipation and preparation, your baby is here!Or maybe not- only 5% of women deliver on their estimated due dates, and many first-time mothers find themselves waiting up to 2 weeks after their due date for their baby to arrive.",
    };


 /**Add background array if you are using different backgrounds*/

    @Override
    public int getCount() {
        return slide_headings.length; //count is equal to number of heading
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object; // change to constraint layout
    }

    @NonNull
    @Override
    //required to give those side effects and inflate all of these in this adapter
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

            //initialize views
            ImageView slideImage = view.findViewById(R.id.imageIV);
            TextView slideHeading  = view.findViewById(R.id.headingTV);
            TextView slideDesc  = view.findViewById(R.id.descTV);

            //setting values
            slideImage.setImageResource(slide_images[position]); // the current position of side will pass to it and it will set image automatically
            slideHeading.setText(slide_headings[position]);
            slideDesc.setText(side_desc[position]);

            container.addView(view);
            return view;
    }

    @Override
    //when we reach last page it will then stop
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
