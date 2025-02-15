Feature: Login 1

  @smoke @sanity @regression
  Scenario: Log into crm
    Given enter username
    When enter password
    When click login
    When click create
    Then click user button


#    Given click administration
#    When click claims module
#    When enter claim number
#    Then click search button

#  @Suite @4567
#  Scenario: Validate login 2
#    Given enter username
#    When enter password
#    Then click login
#
#  @Suite @7892
#  Scenario: Validate login 3
#    Given enter username
#    When enter password
#    Then click login