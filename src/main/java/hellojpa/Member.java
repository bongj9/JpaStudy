package hellojpa;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(name = "member-seq-generator", sequenceName = "member_seq")

public class Member {
    //db에 만들고 이후에 실행
    @Id //기본키
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    //Column은 객체와 테이블을 매핑하는것이다.
    @Column(name = "USERNAME") //객체에는 username이라고 쓰고싶은데 데이터베이스에는 name이라고 하고싶을때 이렇게 쓴다.
    private String name;
    private int age;

    /*    @Column(name = "TEAM_ID")
        private Long teamId;*/
    //연관관계를 써줘야한다.
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }
    //연관관계 편의 메서드
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}

  /*  private Integer age;

    @Enumerated(EnumType.STRING)
    private Roletype roletype;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob //varchar를 넘어서는 큰 컨텐츠를 넣고싶으면 설정
    private String description;
    //문자타입이면 clob

    public Member() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Roletype getRoletype() {
        return roletype;
    }

    public void setRoletype(Roletype roletype) {
        this.roletype = roletype;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/

