# 🇱🇰 Sri Lankan Office Leave Management System

A web-based **Leave Management System** designed for Sri Lankan organizations to digitize and simplify employee leave management, approval workflows, leave balances, holiday management, HR administration, and reporting.

The system is designed to support **employees, managers, HR officers, and system administrators** while allowing organizations to configure their own leave policies and working-day rules.

---

## 📌 Project Overview

Traditional leave management often relies on paper forms, spreadsheets, emails, or manual approval processes. This can lead to:

- Incorrect leave balance calculations
- Delayed approvals
- Lack of transparency
- Difficulty tracking employee leave history
- Manual HR reporting
- Leave conflicts within departments
- Poor visibility of team availability

This system provides a centralized platform where employees can apply for leave, managers can approve requests, and HR can manage policies, balances, holidays, employees, and reports.

---

## 🎯 Objectives

The main objectives of the system are to:

- Digitize the employee leave application process
- Automate leave balance calculations
- Provide configurable leave policies
- Implement multi-level approval workflows
- Manage Sri Lankan public and organizational holidays
- Prevent leave conflicts
- Provide employee and management dashboards
- Generate HR reports and analytics
- Maintain complete audit records
- Provide secure role-based access
- Support multiple departments and organizations

---

# 👥 User Roles

The system supports four main user roles.

### 👤 Employee

Employees can:

- Login securely
- View their profile
- View available leave balances
- Apply for leave
- Apply for half-day leave
- Apply for short leave
- Upload supporting documents
- View leave history
- Cancel pending/approved leave according to policy
- Request leave modifications
- View team leave calendar
- View company holidays
- Receive notifications

---

### 👨‍💼 Manager / Supervisor

Managers can:

- View team members
- View team leave calendar
- View pending leave requests
- Approve leave requests
- Reject leave requests
- Provide rejection reasons
- View employee leave history
- View team leave statistics
- Receive approval notifications

---

### 👩‍💼 HR Officer

HR officers can:

- Manage employees
- Manage departments
- Manage designations
- Create and configure leave types
- Configure leave policies
- Allocate leave balances
- Adjust leave balances
- Manage public/company holidays
- Configure working days
- Manage approval workflows
- Approve exceptional requests
- Generate HR reports
- View organization-wide leave statistics
- Review audit logs

---

### 🔐 System Administrator

Administrators can:

- Manage system users
- Manage roles
- Manage permissions
- Manage departments
- Configure organization settings
- Manage system configurations
- Monitor audit logs
- Manage integrations
- Manage security settings

---

# 🧩 Core Modules

## 1. Authentication & Authorization

The system provides secure authentication and role-based authorization.

Features:

- Login
- Logout
- Password reset
- Password management
- Role-based access control
- Session management
- Account security
- Permission management

---

## 2. Employee Management

HR can manage employee information.

### Personal Information

- Employee ID
- Full name
- Date of birth
- Contact number
- Email
- Address
- NIC/passport information where required

### Employment Information

- Department
- Designation
- Joining date
- Employment type
- Reporting manager
- Work location
- Employment status
- Probation status

### Employment Types

The system can support configurable employment categories such as:

- Permanent
- Contract
- Temporary
- Trainee
- Intern

---

# 📝 3. Leave Management

Employees can submit leave applications through the system.

### Leave Application Flow

```text
Employee
    ↓
Select Leave Type
    ↓
Select Start & End Date
    ↓
Select Full / Half Day
    ↓
Enter Reason
    ↓
Upload Attachment (if required)
    ↓
Submit Request
    ↓
System Validation
    ↓
Approval Workflow
```

The system automatically calculates the requested leave duration based on configured organizational rules.

---

# 📋 4. Leave Types

Leave types should be configurable by HR.

Possible leave types include:

- Annual Leave
- Casual Leave
- Medical / Sick Leave
- Maternity Leave
- Paternity Leave
- No-Pay Leave
- Duty Leave
- Short Leave
- Half-Day Leave
- Other Organization-Specific Leave

> **Note:** Leave entitlements and conditions may vary depending on employee category, applicable Sri Lankan legislation, and organizational policy. Therefore, the system uses configurable leave policies rather than hard-coded entitlements.

---

# ⚙️ 5. Leave Policy Management

HR can configure leave policies for different employee groups.

Policies can define:

- Leave entitlement
- Accumulation method
- Carry-forward rules
- Carry-forward limits
- Expiry rules
- Minimum notice period
- Maximum consecutive leave
- Probation restrictions
- Employee eligibility
- Required documents
- Approval requirements
- Department-specific rules

---

# 📊 6. Leave Balance Management

The system automatically maintains leave balances.

Example:

```text
Annual Leave

Entitled          : 14 Days
Carry Forward     : 03 Days
Adjustments       : 01 Day
Approved Used     : 05 Days
Pending           : 02 Days
Available         : 11 Days
```

The system maintains a clear distinction between:

- Entitled balance
- Used leave
- Pending leave
- Available balance
- Carry-forward
- Adjustments

---

# ✅ 7. Leave Approval Workflow

The system supports configurable approval workflows.

### Simple Workflow

```text
Employee
    ↓
Manager
    ↓
Approved
```

### Multi-Level Workflow

```text
Employee
    ↓
Supervisor
    ↓
Department Manager
    ↓
HR
    ↓
Approved
```

Approval requirements can depend on:

- Leave type
- Leave duration
- Employee department
- Employee position
- Organization policy

---

# 🗓️ 8. Holiday Management

HR can manage the organization's holiday calendar.

The system can support:

- Sri Lankan public holidays
- Bank holidays
- Mercantile holidays where applicable
- Company-specific holidays
- Special holidays
- Organization working days

HR can:

- Add holidays
- Edit holidays
- Remove holidays
- Configure holiday types
- Create annual holiday calendars

> Holiday calendars should remain configurable because applicable holidays and organizational working arrangements can change.

---

# 📅 9. Working-Day Management

Organizations can configure their working schedule.

Example:

```text
Monday      → Working
Tuesday     → Working
Wednesday   → Working
Thursday    → Working
Friday      → Working
Saturday    → Non-Working
Sunday      → Non-Working
```

The system uses the configured working calendar when calculating leave duration.

---

# ⏰ 10. Short Leave & Half-Day Leave

The system supports:

### Short Leave

Example:

```text
Duration: 2 Hours
Reason: Personal
```

HR can configure:

- Maximum duration
- Monthly limits
- Eligibility
- Approval requirements
- Whether short leave affects leave balance

### Half-Day Leave

Supports:

- Morning Half
- Afternoon Half

---

# 📎 11. Supporting Documents

Certain leave types may require supporting documents.

Examples:

- Medical certificates
- Official letters
- Other HR-required documents

The system provides secure document upload and access control.

Only authorized users should be able to access sensitive employee documents.

---

# ❌ 12. Leave Cancellation

Employees can request cancellation of leave according to company policy.

Example:

```text
Approved Leave
       ↓
Cancellation Request
       ↓
Manager / HR Approval
       ↓
Cancellation Approved
       ↓
Balance Updated
```

The original leave record should remain available for auditing.

---

# 🔄 13. Leave Modification

Employees can request changes to an existing leave request.

Example:

```text
Original:
10 September → 12 September

Modified:
11 September → 13 September
```

The system maintains the modification history instead of silently overwriting the original record.

---

# 📆 14. Team Leave Calendar

Managers and authorized users can view team leave information through a calendar.

The calendar can show:

- Employee name
- Leave type
- Start date
- End date
- Leave status
- Department
- Team availability

---

# ⚠️ 15. Leave Conflict Detection

The system can identify potential team availability issues.

Example:

```text
Department: IT

Employees: 10
Currently on Leave: 4
New Request: 2

⚠ High Team Absence
```

The system can warn managers before approval.

Whether the request should be blocked or only warned about depends on organizational policy.

---

# 🔔 16. Notifications

The system provides notifications for important events.

### Employee Notifications

- Leave submitted
- Leave approved
- Leave rejected
- Leave modified
- Leave cancelled
- Leave balance updated

### Manager Notifications

- New leave request
- Pending approval reminder
- Modified request
- Cancellation request

### HR Notifications

- Exceptional leave request
- Policy violations
- Pending HR approvals
- Important employee events

Possible notification channels:

- In-app notifications
- Email
- SMS / other external messaging integrations

---

# 📊 17. Dashboards

## Employee Dashboard

```text
┌───────────────────────────────────────┐
│ Welcome, Employee                    │
├────────────┬────────────┬─────────────┤
│ Annual     │ Casual     │ Medical     │
│ 12 Days    │ 05 Days    │ 07 Days     │
├────────────┴────────────┴─────────────┤
│ Pending Requests: 2                   │
│ Upcoming Leave: 10 September          │
├───────────────────────────────────────┤
│ Company Holidays                      │
└───────────────────────────────────────┘
```

## Manager Dashboard

```text
Pending Approvals       : 8
Team Members            : 24
On Leave Today          : 3
Upcoming Leaves         : 12
```

## HR Dashboard

```text
Total Employees         : 350
On Leave Today          : 27
Pending Requests        : 19
Monthly Leave Requests  : 142
```

---

# 📈 18. Reports & Analytics

HR can generate reports such as:

### Employee Reports

- Employee leave history
- Leave balance
- Leave utilization

### Department Reports

- Department leave usage
- Department absence trends
- Team availability

### Organization Reports

- Monthly leave statistics
- Annual leave statistics
- Leave-type distribution
- Approved vs rejected requests
- No-pay leave statistics

Reports can be exported in:

- PDF
- Excel
- CSV

---

# 🧾 19. Audit Logging

The system maintains an audit trail for important activities.

Audit records may include:

```text
User
Action
Date & Time
Affected Record
Previous Value
New Value
```

Example:

```text
HR Officer
Action: Leave Balance Adjustment

Employee: EMP-1024
Previous Balance: 8 Days
New Balance: 10 Days
Date: 2026-08-31
```

Audit records should not be editable by normal users.

---

# 🤖 20. Optional AI Features

AI can be introduced as an additional layer rather than being required for core leave processing.

Possible features:

- Leave trend analysis
- Absence pattern detection
- Team staffing insights
- Leave conflict prediction
- HR report summaries
- Natural-language HR queries

Example:

> "Which department had the highest leave usage this month?"

The system could analyze organizational data and provide a summary.

AI should not independently make sensitive employment decisions.

---

# 🔗 21. Future Integrations

The platform can be integrated with:

- Attendance management systems
- Payroll systems
- HR management systems
- Email services
- Microsoft 365
- Google Workspace
- Calendar systems
- Enterprise Single Sign-On
- SMS providers

---

# 🗄️ Database Entities

The initial database design may contain:

```text
User
Role
Permission

Employee
Department
Designation

LeaveType
LeavePolicy
LeaveBalance
LeaveRequest
LeaveApproval
LeaveCancellation
LeaveModification

Holiday
WorkSchedule

Notification
Attachment
AuditLog
```

### Basic Relationship

```text
Employee
    │
    ├── Department
    │
    ├── LeaveBalance
    │
    └── LeaveRequest
             │
             └── LeaveApproval
```

---

# 🔐 Security Requirements

The system should implement:

- Secure authentication
- Password hashing
- Role-based access control
- Permission management
- Secure session management
- Input validation
- Secure file uploads
- Protection against SQL injection
- Protection against XSS
- CSRF protection where applicable
- HTTPS
- Rate limiting
- Audit logging
- Secure database access

Sensitive employee information and documents must only be accessible to authorized users.

---

# ⚡ Non-Functional Requirements

## Performance

The application should provide responsive performance for normal employee and HR operations and remain usable as the organization grows.

## Scalability

The system should support organizations ranging from small offices to larger enterprises.

```text
100 Employees
      ↓
1,000 Employees
      ↓
10,000+ Employees
```

## Availability

The system should be reliable during organizational working hours and have appropriate backup and recovery mechanisms.

## Usability

The system should provide a responsive interface for:

- Desktop
- Tablet
- Mobile

## Maintainability

The application should use:

- Modular architecture
- Clean code
- API documentation
- Automated tests
- Database migrations
- Logging
- Version control

---

# 🏗️ Suggested System Architecture

```text
                    WEB APPLICATION
                           │
                           ↓
                   Authentication
                           │
                           ↓
                       REST API
                           │
        ┌──────────────────┼──────────────────┐
        ↓                  ↓                  ↓
   Employee Service   Leave Service      HR Service
        │                  │                  │
        └──────────────────┼──────────────────┘
                           ↓
                       PostgreSQL
                           │
             ┌─────────────┼─────────────┐
             ↓             ↓             ↓
          Storage     Notifications    Reports
```

---

# 🛠️ Suggested Technology Stack

## Frontend

- React
- TypeScript
- HTML5
- CSS3
- Tailwind CSS / other UI framework

## Backend

Possible options:

- Node.js + NestJS
- Node.js + Express
- Java + Spring Boot
- Python + Django/FastAPI

## Database

- PostgreSQL

## Authentication

- Session-based authentication or JWT
- Optional enterprise SSO

## Deployment

- Docker
- CI/CD
- Cloud hosting

---

# 🚀 Development Roadmap

## Phase 1 — Foundation

- Project setup
- Database
- Authentication
- User roles
- Employee management

## Phase 2 — Core Leave Management

- Leave types
- Leave policies
- Leave balances
- Leave applications
- Leave calculations

## Phase 3 — Approval System

- Manager approval
- HR approval
- Multi-level workflows
- Notifications

## Phase 4 — HR Features

- Holiday management
- Working schedules
- Short leave
- Half-day leave
- Documents
- Leave cancellation/modification

## Phase 5 — Analytics

- Dashboards
- Reports
- Charts
- Export functionality
- Audit logs

## Phase 6 — Advanced Features

- AI analytics
- Attendance integration
- Payroll integration
- Calendar integration
- Enterprise SSO
- Mobile optimization

---

# 🎯 Final Goal

The goal is to build a **configurable, secure, scalable Leave & Workforce Management Platform** suitable for Sri Lankan organizations.

The system should not depend on hard-coded leave rules. Instead, organizations should be able to configure:

```text
Leave Policies
       +
Working Days
       +
Holiday Calendar
       +
Approval Workflow
       +
Employee Eligibility
       ↓
Leave Management System
```

This allows the same platform to be adapted to different organizations and their HR policies.

---

## 📌 Project Status

**Status:** 🚧 In Development

**Target:** Production-ready enterprise leave management platform

**Primary Market:** Sri Lankan organizations

**Architecture:** Full-stack web application

**Database:** PostgreSQL

**License:** To be defined
