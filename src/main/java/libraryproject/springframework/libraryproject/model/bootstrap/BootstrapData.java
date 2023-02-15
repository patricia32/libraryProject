package libraryproject.springframework.libraryproject.model.bootstrap;

import libraryproject.springframework.libraryproject.model.Author;
import libraryproject.springframework.libraryproject.model.Book;
import libraryproject.springframework.libraryproject.model.Publisher;
import libraryproject.springframework.libraryproject.model.User;
import libraryproject.springframework.libraryproject.model.repositories.BookRepository;
import libraryproject.springframework.libraryproject.model.repositories.PublisherRepository;
import libraryproject.springframework.libraryproject.model.repositories.UserRepository;
import libraryproject.springframework.libraryproject.model.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

   private final AuthorRepository authorRepository;
   private final BookRepository bookRepository;
   private final PublisherRepository publisherRepository;
   private final UserRepository userRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        User admin = new User("admin", "Patricia Teocan - admin", "parola","0754678656");
        admin.setRole("admin");userRepository.save(admin);
        userRepository.save(admin);

        User user = new User("user", "Patricia Teocan - user", "parola", "0756782637");
        userRepository.save(user);

        // publishers

        Publisher Arthur = new Publisher("Arthur");
        publisherRepository.save(Arthur);
        Publisher Cornerstone = new Publisher("Cornerstone");
        publisherRepository.save(Cornerstone);
        Publisher PanMacmillan = new Publisher("Pan Macmillan");
        publisherRepository.save(PanMacmillan);
        Publisher ProfileBooksLtd = new Publisher("Profile Books Ltd");
        publisherRepository.save(ProfileBooksLtd);
        Publisher HodderStoughton = new Publisher("Hodder & Stoughton");
        publisherRepository.save(HodderStoughton);
        Publisher CanongateBooks = new Publisher("Canongate Books");
        publisherRepository.save(CanongateBooks);
        Publisher HayHouseUKLtd = new Publisher("Hay House UK Ltd");
        publisherRepository.save(HayHouseUKLtd);
        Publisher HeadlinePublishingGroup = new Publisher("HeadlinePublishingGroup");
        publisherRepository.save(HeadlinePublishingGroup);


        //authors

        Author jamesClear = new Author("James Clear", 43);
        authorRepository.save(jamesClear);
        Author ToshikazuKawaguchi = new Author("Toshikazu Kawaguchi", 63);
        authorRepository.save(ToshikazuKawaguchi);
        Author RyanHoliday = new Author("Ryan Holiday", 32);
        authorRepository.save(RyanHoliday);
        Author DonnaTartt = new Author(" Donna Tartt", 53);
        authorRepository.save(DonnaTartt);
        Author LucyScore = new Author("Lucy Score", 24);
        authorRepository.save(LucyScore);
        Author MattHaig = new Author("Matt Haig", 42);
        authorRepository.save(MattHaig);
        Author JenniferNiven = new Author("Jennifer Niven", 32);
        authorRepository.save(JenniferNiven);
        Author YasminBoland = new Author("Yasmin Boland", 43);
        authorRepository.save(YasminBoland);
        Author ArabelaSoloean = new Author("Arabela Solonean", 30);
        authorRepository.save(ArabelaSoloean);
        Author ValentineLow = new Author("Valentine Low", 34);
        authorRepository.save(ValentineLow);
        Author AndrewSeanGreer = new Author("Andrew Sean Greer", 32);
        authorRepository.save(AndrewSeanGreer);
        Author RichardPowers = new Author("Richard Powers", 53);
        authorRepository.save(RichardPowers);
        Author JohnGardner = new Author("John Gardner", 34);
        authorRepository.save(JohnGardner);
        Author StellaCottrell = new Author("Stella Cottrell", 23);
        authorRepository.save(StellaCottrell);


        Book atomicHabits = new Book("Atomic Habits", "12345", 320, "Universal literature",40, "English");
        atomicHabits.setImagePath1("../atomic.jpg");
        atomicHabits.setDescription("People think that when you want to change your life, you need to think big. But world-renowned habits expert James Clear has discovered another way.He knows that real change comes from the compound effect of hundreds of small decisions.");
        atomicHabits.setBestseller(Boolean.TRUE);

        jamesClear.increaseBooksNumber();
        atomicHabits.setAuthors("James Clear");
        atomicHabits.setPublisher("Cornerstone");
        bookRepository.save(atomicHabits);

        Book beforetheCoffeeGetsCold = new Book("Before the Coffee Gets Cold","93274982", 224, "Fiction", 55, "English");
        beforetheCoffeeGetsCold.setImagePath1("../beforeTheCoffee.jpg");
        beforetheCoffeeGetsCold.setDescription("In a small back alley in Tokyo, there is a cafe which has been serving carefully brewed coffee for more than one hundred years. But this coffee shop offers its customers a unique experience: the chance to travel back in time.");
        beforetheCoffeeGetsCold.setBestseller(Boolean.TRUE);
        ToshikazuKawaguchi.increaseBooksNumber();
        beforetheCoffeeGetsCold.setAuthors("Toshikazu Kawaguchi");
        beforetheCoffeeGetsCold.setPublisher("PanMacmillan");
        bookRepository.save(beforetheCoffeeGetsCold);

        Book theDailyStoic = new Book("The Daily Stoic","12312", 416, "Personal Development", 55,"English");
        theDailyStoic.setImagePath1("../dailyStoic.jpg");
        theDailyStoic.setDescription("'A generous gift of guidance on modern living culled from a canon of wisdom hatched long ago.' - Maria Popova, editor of Brain Pickings\n");
        theDailyStoic.setBestseller(Boolean.TRUE);
        RyanHoliday.increaseBooksNumber();
        theDailyStoic.setAuthors("Ryan Holiday");
        theDailyStoic.setPublisher("PanMacmillan");
        bookRepository.save(theDailyStoic);

        Book theSecretHistory = new Book("The Secret History","827627", 640, "Fiction", 61,"Romanian");
        theSecretHistory.setImagePath1("../secretHistory.jpg");
        theSecretHistory.setDescription("'Everything, somehow, fit together; some sly and benevolent Providence was revealing itself by degrees and I felt myself trembling on the brink of a fabulous discovery, as though any morning it was all going to come together.");
        theSecretHistory.setBestseller(Boolean.TRUE);
        DonnaTartt.increaseBooksNumber();
        theSecretHistory.setAuthors("Donna Tartt");
        theSecretHistory.setPublisher("ProfileBooksLtd");
        bookRepository.save(theSecretHistory);

        Book essereFelice = new Book("Anch'io voglio essere felice", "43322", 164, "Personal Development", 64, "English");
        essereFelice.setBestseller(Boolean.TRUE);
        essereFelice.setDescription("Il libro parla del viaggio che ho intrapreso per raggiungere la felicità in tutte le aree della vita, parla in modo chiaro e semplice, con esempi della vita di tutti giorni.");
        essereFelice.setImagePath1("../essereFelice.jpg");
        ArabelaSoloean.increaseBooksNumber();
        essereFelice.setAuthors("Arabela Soloean");
        essereFelice.setPublisher("ProfileBooksLtd");
        bookRepository.save(essereFelice);

        Book thingsWeNeverGotOver = new Book("Things We Never Got Over", "42235", 496, "Fiction",48,"Romanian");
        thingsWeNeverGotOver.setImagePath1("../things.jpg");
        thingsWeNeverGotOver.setDescription("'I laughed. I cried. I laughed while I cried, and I definitely blushed' Book Addict. Grumpy, small-town barber + hopelessly romantic runaway bride = great big bust ups, all the tension and lots of steamy encounters!");
        thingsWeNeverGotOver.setBestseller(Boolean.TRUE);
        LucyScore.increaseBooksNumber();
        thingsWeNeverGotOver.setAuthors("Lucy Score");
        thingsWeNeverGotOver.setPublisher("HodderStoughton");
        bookRepository.save(thingsWeNeverGotOver);

        Book theMidnightLibrary = new Book("The Midnight Library", "33134", 304, "Fiction",48,"Romanian");
        theMidnightLibrary.setImagePath1("../midnight.jpg");
        theMidnightLibrary.setDescription("Nora's life has been going from bad to worse. Then at the stroke of midnight on her last day on earth she finds herself transported to a library. There she is given the chance to undo her regrets and try out each of the other lives she might have lived.");
        theMidnightLibrary.setBestseller(Boolean.TRUE);
        MattHaig.increaseBooksNumber();
        theMidnightLibrary.setAuthors("Matt Haig");
        theMidnightLibrary.setPublisher("CanongateBooks");
        bookRepository.save(theMidnightLibrary);


        Book allTheBrightPlaces = new Book("All the bright places", "435432", 432, "Fiction", 42, "English");
        allTheBrightPlaces.setBestseller(Boolean.TRUE);
        allTheBrightPlaces.setDescription("When Finch and Violet meet on the ledge of the bell tower at school, it's unclear who saves whom. And when they pair up on a project to discover the 'natural wonders' of their state, both Finch and Violet make more important discoveries.");
        allTheBrightPlaces.setImagePath1("../all-the-bright-places.jpg");
        JenniferNiven.increaseBooksNumber();
        allTheBrightPlaces.setAuthors("Jennifer Niven");
        allTheBrightPlaces.setPublisher("ProfileBooksLtd");
        bookRepository.save(allTheBrightPlaces);

        Book moonology = new Book("Moonology", "843792", 288, "Personal Development", 79, "English");
        moonology.setBestseller(Boolean.TRUE);
        moonology.setDescription("Complete with a guidebook for easy card interpretation, this astrology-based oracle deck will help you achieve your goals, improve your decision making, and manifest positive, lasting change.");
        moonology.setImagePath1("../moonology.jpg");
        YasminBoland.increaseBooksNumber();
        moonology.setAuthors("Yasmin Boland");
        moonology.setPublisher("HayHouseUKLtd");
        authorRepository.save(YasminBoland);
        bookRepository.save(moonology);

        Book Courtiers  = new Book("Courtiers", "6453", 384, "Biography", 90, "English");
        Courtiers.setnewReleases(Boolean.TRUE);
        Courtiers.setDescription("Complete with a guidebook for easy card interpretation, this astrology-based oracle deck will help you achieve your goals, improve your decision making, and manifest positive, lasting change.");
        Courtiers.setImagePath1("../Courtiers.jpg");
        ArabelaSoloean.increaseBooksNumber();
        Courtiers.setAuthors("Arabela Soloean");
        Courtiers.setPublisher("ProfileBooksLtd");
        bookRepository.save(Courtiers );

        Book Less = new Book("Less", "3839", 272, "Fiction", 64, "Romanian");
        Less.setDescription("Arthur Less is a failed novelist about to turn fifty. A wedding invitation arrives in the post: it is from an ex-boyfriend of nine years who is engaged to someone else.");
        Less.setImagePath1("../less.jpg");
        AndrewSeanGreer.increaseBooksNumber();
        Less.setAuthors("Andrew Sean Greer");
        Less.setPublisher("ProfileBooksLtd");
        bookRepository.save(Less);

        Book theOverstory  = new Book("The Overstory", "43479", 640, "Fiction", 64, "Romanian");
        theOverstory .setDescription("A wondrous, exhilarating novel about nine strangers brought together by an unfolding natural catastrophe. The perfect literary escape.");
        theOverstory .setImagePath1("../theOverstory.jpg");
        RichardPowers.increaseBooksNumber();
        theOverstory .setAuthors("Richard Powers");
        theOverstory .setPublisher("ProfileBooksLtd");
        bookRepository.save(theOverstory );

        Book theArt   = new Book("The Art of Fiction", "3492", 240, "Fiction", 79, "Romanian");
        theArt.setDescription("John Gardner was almost as famous as a teacher of creative writing as he was for his own works. In this practical, instructive handbook, based on the courses and seminars that he gave, he explains, simply and cogently.");
        theArt.setImagePath1("../theArt.jpg");
        JohnGardner.increaseBooksNumber();
        theArt.setAuthors("John Gardner");
        theArt.setPublisher("ProfileBooksLtd");
        bookRepository.save(theArt  );

        Book skillsForSuccess = new Book("Skills for Success", "43322", 400, "Personal Development", 89, "Romanian");
        skillsForSuccess.setDescription("Whatever stage your students are at, it's never too soon for them to be thinking about their future. Competition for jobs is fierce, and having a degree is no longer enough. This indispensable guide helps students.");
        skillsForSuccess.setImagePath1("../skills.jpg");
        StellaCottrell.increaseBooksNumber();
        skillsForSuccess.setAuthors("Stella Cottrell");
        skillsForSuccess.setPublisher("CanongateBooks");
        bookRepository.save(skillsForSuccess);


        Book personalandProfessionalDevelopment = new Book("Personal and Professional Development", "42235", 496, "Personal Development",65,"Romanian");
        personalandProfessionalDevelopment.setImagePath1("../personal.jpg");
        personalandProfessionalDevelopment.setDescription("This book provides a comprehensive, accessible and research-informed approach to personal development issues associated with the role of a counsellor, therapist or mental health practitioner. Written by leading authors in the field.");
        LucyScore.increaseBooksNumber();
        personalandProfessionalDevelopment.setAuthors("LucyScore");
        personalandProfessionalDevelopment.setPublisher("Hodder Stoughton");
        bookRepository.save(personalandProfessionalDevelopment);


        Book writeYourself = new Book("Write Yourself", "3981792", 288, "Personal Development", 93, "English");
        writeYourself.setDescription("Write Yourself is a complete introduction to facilitating creative writing for therapy or personal development, both with individuals and groups. Clear and practical, and with a strong theoretical base, it is also an essential handbook.");
        writeYourself.setImagePath1("../writeYourself.jpg");
        YasminBoland.increaseBooksNumber();
        writeYourself.setAuthors("Yasmin Boland");
        writeYourself.setPublisher("HayHouseUKLtd");
        authorRepository.save(YasminBoland);
        bookRepository.save(writeYourself);

        Book writingWorks = new Book("Writing Works", "4632", 256, "Personal Development",99,"English");
        writingWorks.setImagePath1("../writingWorks.jpg");
        writingWorks.setDescription("The use of creative writing as a route to personal development is a powerful therapeutic tool - a fact that is recognized in the growing numbers of workshops and writing groups within professional contexts, including clinical settings.");
        LucyScore.increaseBooksNumber();
        writingWorks.setAuthors("LucyScore");
        writingWorks.setPublisher("Hodder Stoughton");
        bookRepository.save(writingWorks);

        Book PersonalityDevelopment = new Book("Personality Development","32928", 224, "Personal Development", 71,"Romanian");
        PersonalityDevelopment.setImagePath1("../develop.jpg");
        PersonalityDevelopment.setDescription("Personality Development is a comprehensive overview of infant observation and personality development. It starts at inter-utero life and goes through to adulthood, focusing on the emotional tasks.");

        DonnaTartt.increaseBooksNumber();
        PersonalityDevelopment.setAuthors("Donna Tartt");
        PersonalityDevelopment.setPublisher("ProfileBooksLtd");
        bookRepository.save(PersonalityDevelopment);



        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
