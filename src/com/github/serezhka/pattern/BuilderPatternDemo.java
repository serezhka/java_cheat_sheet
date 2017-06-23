package com.github.serezhka.pattern;

/**
 * @author Sergei Fedorov (serezhka@xakep.ru)
 * @since 23.06.2017
 */
public class BuilderPatternDemo {

    private static class Robot {
        private final String head;
        private final String arm;
        private final String torse;
        private final String leg;

        private Robot(String head, String arm, String torse, String leg) {
            this.head = head;
            this.arm = arm;
            this.torse = torse;
            this.leg = leg;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "head='" + head + '\'' +
                    ", arm='" + arm + '\'' +
                    ", tors='" + torse + '\'' +
                    ", leg='" + leg + '\'' +
                    '}';
        }

        private static class RobotBuilder {
            private String head = "default head";
            private String arm = "default arm";
            private String tors = "default tors";
            private String leg = "default leg";

            public RobotBuilder setHead(String head) {
                this.head = head;
                return this;
            }

            public RobotBuilder setArm(String arm) {
                this.arm = arm;
                return this;
            }

            public RobotBuilder setTors(String tors) {
                this.tors = tors;
                return this;
            }

            public RobotBuilder setLeg(String leg) {
                this.leg = leg;
                return this;
            }

            public Robot build() {
                return new Robot(head, arm, tors, leg);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Robot.RobotBuilder().setHead("BIG HEAD").build());
    }
}
