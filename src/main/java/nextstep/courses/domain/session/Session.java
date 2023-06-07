package nextstep.courses.domain.session;

import nextstep.courses.domain.BaseEntity;
import nextstep.users.domain.NsUser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Session extends BaseEntity {
    private final Long courseId;

    private final Long sessionNumber;

    private final SessionPeriod sessionPeriod;

    private final CoverImage coverImage;

    private final Students students;

    public Session(
            Long id,
            String title,
            Long courseId,
            Long sessionNumber,
            SessionPeriod sessionPeriod,
            CoverImage coverImage,
            Students students,
            Long creatorId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(courseId);
        Objects.requireNonNull(sessionNumber);
        Objects.requireNonNull(sessionPeriod);
        Objects.requireNonNull(coverImage);
        Objects.requireNonNull(students);
        Objects.requireNonNull(creatorId);
        Objects.requireNonNull(createdAt);
        this.id = id;
        this.title = title;
        this.courseId = courseId;
        this.sessionNumber = sessionNumber;
        this.sessionPeriod = sessionPeriod;
        this.coverImage = coverImage;
        this.students = students;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Session initUsers(List<Student> students) {
        this.students.initUsers(students);
        return this;
    }

    public Session validateRegister(NsUser nsUser) {
        students.validateRegister(nsUser);
        return this;
    }

    public Session startRecruit() {
        sessionPeriod.checkRecruit();
        students.startRecruit();
        return this;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Long getSessionNumber() {
        return sessionNumber;
    }

    public SessionPeriod getSessionPeriod() {
        return sessionPeriod;
    }

    public CoverImage getCoverImage() {
        return coverImage;
    }

    public Students getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Session{" +
                "courseId=" + courseId +
                ", sessionNumber=" + sessionNumber +
                ", sessionPeriod=" + sessionPeriod +
                ", coverImage=" + coverImage +
                ", students=" + students +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", creatorId=" + creatorId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}